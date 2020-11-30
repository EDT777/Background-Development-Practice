package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.RelativeGoodsItemService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.RelativeGoodsItemDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.RelativeGoodsItem}.
 */
@RestController
@RequestMapping("/api")
public class RelativeGoodsItemResource {

    private final Logger log = LoggerFactory.getLogger(RelativeGoodsItemResource.class);

    private static final String ENTITY_NAME = "relativeGoodsItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RelativeGoodsItemService relativeGoodsItemService;

    public RelativeGoodsItemResource(RelativeGoodsItemService relativeGoodsItemService) {
        this.relativeGoodsItemService = relativeGoodsItemService;
    }

    /**
     * {@code POST  /relative-goods-items} : Create a new relativeGoodsItem.
     *
     * @param relativeGoodsItemDTO the relativeGoodsItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new relativeGoodsItemDTO, or with status {@code 400 (Bad Request)} if the relativeGoodsItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/relative-goods-items")
    public ResponseEntity<RelativeGoodsItemDTO> createRelativeGoodsItem(@RequestBody RelativeGoodsItemDTO relativeGoodsItemDTO) throws URISyntaxException {
        log.debug("REST request to save RelativeGoodsItem : {}", relativeGoodsItemDTO);
        if (relativeGoodsItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new relativeGoodsItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RelativeGoodsItemDTO result = relativeGoodsItemService.save(relativeGoodsItemDTO);
        return ResponseEntity.created(new URI("/api/relative-goods-items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /relative-goods-items} : Updates an existing relativeGoodsItem.
     *
     * @param relativeGoodsItemDTO the relativeGoodsItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated relativeGoodsItemDTO,
     * or with status {@code 400 (Bad Request)} if the relativeGoodsItemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the relativeGoodsItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/relative-goods-items")
    public ResponseEntity<RelativeGoodsItemDTO> updateRelativeGoodsItem(@RequestBody RelativeGoodsItemDTO relativeGoodsItemDTO) throws URISyntaxException {
        log.debug("REST request to update RelativeGoodsItem : {}", relativeGoodsItemDTO);
        if (relativeGoodsItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RelativeGoodsItemDTO result = relativeGoodsItemService.save(relativeGoodsItemDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, relativeGoodsItemDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /relative-goods-items} : get all the relativeGoodsItems.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of relativeGoodsItems in body.
     */
    @GetMapping("/relative-goods-items")
    public ResponseEntity<List<RelativeGoodsItemDTO>> getAllRelativeGoodsItems(Pageable pageable) {
        log.debug("REST request to get a page of RelativeGoodsItems");
        Page<RelativeGoodsItemDTO> page = relativeGoodsItemService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /relative-goods-items/:id} : get the "id" relativeGoodsItem.
     *
     * @param id the id of the relativeGoodsItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the relativeGoodsItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/relative-goods-items/{id}")
    public ResponseEntity<RelativeGoodsItemDTO> getRelativeGoodsItem(@PathVariable Long id) {
        log.debug("REST request to get RelativeGoodsItem : {}", id);
        Optional<RelativeGoodsItemDTO> relativeGoodsItemDTO = relativeGoodsItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(relativeGoodsItemDTO);
    }

    /**
     * {@code DELETE  /relative-goods-items/:id} : delete the "id" relativeGoodsItem.
     *
     * @param id the id of the relativeGoodsItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/relative-goods-items/{id}")
    public ResponseEntity<Void> deleteRelativeGoodsItem(@PathVariable Long id) {
        log.debug("REST request to delete RelativeGoodsItem : {}", id);
        relativeGoodsItemService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
