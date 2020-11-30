package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.InfoItemVisitDataService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.InfoItemVisitDataDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.InfoItemVisitData}.
 */
@RestController
@RequestMapping("/api")
public class InfoItemVisitDataResource {

    private final Logger log = LoggerFactory.getLogger(InfoItemVisitDataResource.class);

    private static final String ENTITY_NAME = "infoItemVisitData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InfoItemVisitDataService infoItemVisitDataService;

    public InfoItemVisitDataResource(InfoItemVisitDataService infoItemVisitDataService) {
        this.infoItemVisitDataService = infoItemVisitDataService;
    }

    /**
     * {@code POST  /info-item-visit-data} : Create a new infoItemVisitData.
     *
     * @param infoItemVisitDataDTO the infoItemVisitDataDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new infoItemVisitDataDTO, or with status {@code 400 (Bad Request)} if the infoItemVisitData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/info-item-visit-data")
    public ResponseEntity<InfoItemVisitDataDTO> createInfoItemVisitData(@RequestBody InfoItemVisitDataDTO infoItemVisitDataDTO) throws URISyntaxException {
        log.debug("REST request to save InfoItemVisitData : {}", infoItemVisitDataDTO);
        if (infoItemVisitDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new infoItemVisitData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InfoItemVisitDataDTO result = infoItemVisitDataService.save(infoItemVisitDataDTO);
        return ResponseEntity.created(new URI("/api/info-item-visit-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /info-item-visit-data} : Updates an existing infoItemVisitData.
     *
     * @param infoItemVisitDataDTO the infoItemVisitDataDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated infoItemVisitDataDTO,
     * or with status {@code 400 (Bad Request)} if the infoItemVisitDataDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the infoItemVisitDataDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/info-item-visit-data")
    public ResponseEntity<InfoItemVisitDataDTO> updateInfoItemVisitData(@RequestBody InfoItemVisitDataDTO infoItemVisitDataDTO) throws URISyntaxException {
        log.debug("REST request to update InfoItemVisitData : {}", infoItemVisitDataDTO);
        if (infoItemVisitDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InfoItemVisitDataDTO result = infoItemVisitDataService.save(infoItemVisitDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, infoItemVisitDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /info-item-visit-data} : get all the infoItemVisitData.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of infoItemVisitData in body.
     */
    @GetMapping("/info-item-visit-data")
    public ResponseEntity<List<InfoItemVisitDataDTO>> getAllInfoItemVisitData(Pageable pageable) {
        log.debug("REST request to get a page of InfoItemVisitData");
        Page<InfoItemVisitDataDTO> page = infoItemVisitDataService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /info-item-visit-data/:id} : get the "id" infoItemVisitData.
     *
     * @param id the id of the infoItemVisitDataDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the infoItemVisitDataDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/info-item-visit-data/{id}")
    public ResponseEntity<InfoItemVisitDataDTO> getInfoItemVisitData(@PathVariable Long id) {
        log.debug("REST request to get InfoItemVisitData : {}", id);
        Optional<InfoItemVisitDataDTO> infoItemVisitDataDTO = infoItemVisitDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(infoItemVisitDataDTO);
    }

    /**
     * {@code DELETE  /info-item-visit-data/:id} : delete the "id" infoItemVisitData.
     *
     * @param id the id of the infoItemVisitDataDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/info-item-visit-data/{id}")
    public ResponseEntity<Void> deleteInfoItemVisitData(@PathVariable Long id) {
        log.debug("REST request to delete InfoItemVisitData : {}", id);
        infoItemVisitDataService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
