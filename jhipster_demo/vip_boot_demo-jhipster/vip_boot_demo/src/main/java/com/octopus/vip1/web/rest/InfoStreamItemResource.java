package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.InfoStreamItemService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.InfoStreamItemDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.octopus.vip1.domain.InfoStreamItem}.
 */
@RestController
@RequestMapping("/api")
public class InfoStreamItemResource {

    private final Logger log = LoggerFactory.getLogger(InfoStreamItemResource.class);

    private static final String ENTITY_NAME = "infoStreamItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InfoStreamItemService infoStreamItemService;

    public InfoStreamItemResource(InfoStreamItemService infoStreamItemService) {
        this.infoStreamItemService = infoStreamItemService;
    }

    /**
     * {@code POST  /info-stream-items} : Create a new infoStreamItem.
     *
     * @param infoStreamItemDTO the infoStreamItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new infoStreamItemDTO, or with status {@code 400 (Bad Request)} if the infoStreamItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/info-stream-items")
    public ResponseEntity<InfoStreamItemDTO> createInfoStreamItem(@RequestBody InfoStreamItemDTO infoStreamItemDTO) throws URISyntaxException {
        log.debug("REST request to save InfoStreamItem : {}", infoStreamItemDTO);
        if (infoStreamItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new infoStreamItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InfoStreamItemDTO result = infoStreamItemService.save(infoStreamItemDTO);
        return ResponseEntity.created(new URI("/api/info-stream-items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /info-stream-items} : Updates an existing infoStreamItem.
     *
     * @param infoStreamItemDTO the infoStreamItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated infoStreamItemDTO,
     * or with status {@code 400 (Bad Request)} if the infoStreamItemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the infoStreamItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/info-stream-items")
    public ResponseEntity<InfoStreamItemDTO> updateInfoStreamItem(@RequestBody InfoStreamItemDTO infoStreamItemDTO) throws URISyntaxException {
        log.debug("REST request to update InfoStreamItem : {}", infoStreamItemDTO);
        if (infoStreamItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InfoStreamItemDTO result = infoStreamItemService.save(infoStreamItemDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, infoStreamItemDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /info-stream-items} : get all the infoStreamItems.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of infoStreamItems in body.
     */
    @GetMapping("/info-stream-items")
    public ResponseEntity<List<InfoStreamItemDTO>> getAllInfoStreamItems(Pageable pageable) {
        log.debug("REST request to get a page of InfoStreamItems");
        Page<InfoStreamItemDTO> page = infoStreamItemService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /info-stream-items/:id} : get the "id" infoStreamItem.
     *
     * @param id the id of the infoStreamItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the infoStreamItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/info-stream-items/{id}")
    public ResponseEntity<InfoStreamItemDTO> getInfoStreamItem(@PathVariable Long id) {
        log.debug("REST request to get InfoStreamItem : {}", id);
        Optional<InfoStreamItemDTO> infoStreamItemDTO = infoStreamItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(infoStreamItemDTO);
    }

    /**
     * {@code DELETE  /info-stream-items/:id} : delete the "id" infoStreamItem.
     *
     * @param id the id of the infoStreamItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/info-stream-items/{id}")
    public ResponseEntity<Void> deleteInfoStreamItem(@PathVariable Long id) {
        log.debug("REST request to delete InfoStreamItem : {}", id);
        infoStreamItemService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
