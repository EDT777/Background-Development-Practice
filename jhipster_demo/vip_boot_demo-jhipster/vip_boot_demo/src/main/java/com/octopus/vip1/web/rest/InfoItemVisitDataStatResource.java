package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.InfoItemVisitDataStatService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.InfoItemVisitDataStatDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.InfoItemVisitDataStat}.
 */
@RestController
@RequestMapping("/api")
public class InfoItemVisitDataStatResource {

    private final Logger log = LoggerFactory.getLogger(InfoItemVisitDataStatResource.class);

    private static final String ENTITY_NAME = "infoItemVisitDataStat";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InfoItemVisitDataStatService infoItemVisitDataStatService;

    public InfoItemVisitDataStatResource(InfoItemVisitDataStatService infoItemVisitDataStatService) {
        this.infoItemVisitDataStatService = infoItemVisitDataStatService;
    }

    /**
     * {@code POST  /info-item-visit-data-stats} : Create a new infoItemVisitDataStat.
     *
     * @param infoItemVisitDataStatDTO the infoItemVisitDataStatDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new infoItemVisitDataStatDTO, or with status {@code 400 (Bad Request)} if the infoItemVisitDataStat has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/info-item-visit-data-stats")
    public ResponseEntity<InfoItemVisitDataStatDTO> createInfoItemVisitDataStat(@RequestBody InfoItemVisitDataStatDTO infoItemVisitDataStatDTO) throws URISyntaxException {
        log.debug("REST request to save InfoItemVisitDataStat : {}", infoItemVisitDataStatDTO);
        if (infoItemVisitDataStatDTO.getId() != null) {
            throw new BadRequestAlertException("A new infoItemVisitDataStat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InfoItemVisitDataStatDTO result = infoItemVisitDataStatService.save(infoItemVisitDataStatDTO);
        return ResponseEntity.created(new URI("/api/info-item-visit-data-stats/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /info-item-visit-data-stats} : Updates an existing infoItemVisitDataStat.
     *
     * @param infoItemVisitDataStatDTO the infoItemVisitDataStatDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated infoItemVisitDataStatDTO,
     * or with status {@code 400 (Bad Request)} if the infoItemVisitDataStatDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the infoItemVisitDataStatDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/info-item-visit-data-stats")
    public ResponseEntity<InfoItemVisitDataStatDTO> updateInfoItemVisitDataStat(@RequestBody InfoItemVisitDataStatDTO infoItemVisitDataStatDTO) throws URISyntaxException {
        log.debug("REST request to update InfoItemVisitDataStat : {}", infoItemVisitDataStatDTO);
        if (infoItemVisitDataStatDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InfoItemVisitDataStatDTO result = infoItemVisitDataStatService.save(infoItemVisitDataStatDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, infoItemVisitDataStatDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /info-item-visit-data-stats} : get all the infoItemVisitDataStats.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of infoItemVisitDataStats in body.
     */
    @GetMapping("/info-item-visit-data-stats")
    public ResponseEntity<List<InfoItemVisitDataStatDTO>> getAllInfoItemVisitDataStats(Pageable pageable) {
        log.debug("REST request to get a page of InfoItemVisitDataStats");
        Page<InfoItemVisitDataStatDTO> page = infoItemVisitDataStatService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /info-item-visit-data-stats/:id} : get the "id" infoItemVisitDataStat.
     *
     * @param id the id of the infoItemVisitDataStatDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the infoItemVisitDataStatDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/info-item-visit-data-stats/{id}")
    public ResponseEntity<InfoItemVisitDataStatDTO> getInfoItemVisitDataStat(@PathVariable Long id) {
        log.debug("REST request to get InfoItemVisitDataStat : {}", id);
        Optional<InfoItemVisitDataStatDTO> infoItemVisitDataStatDTO = infoItemVisitDataStatService.findOne(id);
        return ResponseUtil.wrapOrNotFound(infoItemVisitDataStatDTO);
    }

    /**
     * {@code DELETE  /info-item-visit-data-stats/:id} : delete the "id" infoItemVisitDataStat.
     *
     * @param id the id of the infoItemVisitDataStatDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/info-item-visit-data-stats/{id}")
    public ResponseEntity<Void> deleteInfoItemVisitDataStat(@PathVariable Long id) {
        log.debug("REST request to delete InfoItemVisitDataStat : {}", id);
        infoItemVisitDataStatService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
