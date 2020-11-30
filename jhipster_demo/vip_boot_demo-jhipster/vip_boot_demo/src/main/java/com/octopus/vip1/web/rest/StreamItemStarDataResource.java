package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.StreamItemStarDataService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.StreamItemStarDataDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.StreamItemStarData}.
 */
@RestController
@RequestMapping("/api")
public class StreamItemStarDataResource {

    private final Logger log = LoggerFactory.getLogger(StreamItemStarDataResource.class);

    private static final String ENTITY_NAME = "streamItemStarData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StreamItemStarDataService streamItemStarDataService;

    public StreamItemStarDataResource(StreamItemStarDataService streamItemStarDataService) {
        this.streamItemStarDataService = streamItemStarDataService;
    }

    /**
     * {@code POST  /stream-item-star-data} : Create a new streamItemStarData.
     *
     * @param streamItemStarDataDTO the streamItemStarDataDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new streamItemStarDataDTO, or with status {@code 400 (Bad Request)} if the streamItemStarData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/stream-item-star-data")
    public ResponseEntity<StreamItemStarDataDTO> createStreamItemStarData(@RequestBody StreamItemStarDataDTO streamItemStarDataDTO) throws URISyntaxException {
        log.debug("REST request to save StreamItemStarData : {}", streamItemStarDataDTO);
        if (streamItemStarDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new streamItemStarData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StreamItemStarDataDTO result = streamItemStarDataService.save(streamItemStarDataDTO);
        return ResponseEntity.created(new URI("/api/stream-item-star-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stream-item-star-data} : Updates an existing streamItemStarData.
     *
     * @param streamItemStarDataDTO the streamItemStarDataDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated streamItemStarDataDTO,
     * or with status {@code 400 (Bad Request)} if the streamItemStarDataDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the streamItemStarDataDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/stream-item-star-data")
    public ResponseEntity<StreamItemStarDataDTO> updateStreamItemStarData(@RequestBody StreamItemStarDataDTO streamItemStarDataDTO) throws URISyntaxException {
        log.debug("REST request to update StreamItemStarData : {}", streamItemStarDataDTO);
        if (streamItemStarDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StreamItemStarDataDTO result = streamItemStarDataService.save(streamItemStarDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, streamItemStarDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /stream-item-star-data} : get all the streamItemStarData.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of streamItemStarData in body.
     */
    @GetMapping("/stream-item-star-data")
    public ResponseEntity<List<StreamItemStarDataDTO>> getAllStreamItemStarData(Pageable pageable) {
        log.debug("REST request to get a page of StreamItemStarData");
        Page<StreamItemStarDataDTO> page = streamItemStarDataService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /stream-item-star-data/:id} : get the "id" streamItemStarData.
     *
     * @param id the id of the streamItemStarDataDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the streamItemStarDataDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stream-item-star-data/{id}")
    public ResponseEntity<StreamItemStarDataDTO> getStreamItemStarData(@PathVariable Long id) {
        log.debug("REST request to get StreamItemStarData : {}", id);
        Optional<StreamItemStarDataDTO> streamItemStarDataDTO = streamItemStarDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(streamItemStarDataDTO);
    }

    /**
     * {@code DELETE  /stream-item-star-data/:id} : delete the "id" streamItemStarData.
     *
     * @param id the id of the streamItemStarDataDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stream-item-star-data/{id}")
    public ResponseEntity<Void> deleteStreamItemStarData(@PathVariable Long id) {
        log.debug("REST request to delete StreamItemStarData : {}", id);
        streamItemStarDataService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
