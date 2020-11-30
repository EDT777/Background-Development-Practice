package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.ReplyVisitDataStatService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.ReplyVisitDataStatDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.ReplyVisitDataStat}.
 */
@RestController
@RequestMapping("/api")
public class ReplyVisitDataStatResource {

    private final Logger log = LoggerFactory.getLogger(ReplyVisitDataStatResource.class);

    private static final String ENTITY_NAME = "replyVisitDataStat";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReplyVisitDataStatService replyVisitDataStatService;

    public ReplyVisitDataStatResource(ReplyVisitDataStatService replyVisitDataStatService) {
        this.replyVisitDataStatService = replyVisitDataStatService;
    }

    /**
     * {@code POST  /reply-visit-data-stats} : Create a new replyVisitDataStat.
     *
     * @param replyVisitDataStatDTO the replyVisitDataStatDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new replyVisitDataStatDTO, or with status {@code 400 (Bad Request)} if the replyVisitDataStat has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reply-visit-data-stats")
    public ResponseEntity<ReplyVisitDataStatDTO> createReplyVisitDataStat(@RequestBody ReplyVisitDataStatDTO replyVisitDataStatDTO) throws URISyntaxException {
        log.debug("REST request to save ReplyVisitDataStat : {}", replyVisitDataStatDTO);
        if (replyVisitDataStatDTO.getId() != null) {
            throw new BadRequestAlertException("A new replyVisitDataStat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReplyVisitDataStatDTO result = replyVisitDataStatService.save(replyVisitDataStatDTO);
        return ResponseEntity.created(new URI("/api/reply-visit-data-stats/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reply-visit-data-stats} : Updates an existing replyVisitDataStat.
     *
     * @param replyVisitDataStatDTO the replyVisitDataStatDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated replyVisitDataStatDTO,
     * or with status {@code 400 (Bad Request)} if the replyVisitDataStatDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the replyVisitDataStatDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reply-visit-data-stats")
    public ResponseEntity<ReplyVisitDataStatDTO> updateReplyVisitDataStat(@RequestBody ReplyVisitDataStatDTO replyVisitDataStatDTO) throws URISyntaxException {
        log.debug("REST request to update ReplyVisitDataStat : {}", replyVisitDataStatDTO);
        if (replyVisitDataStatDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReplyVisitDataStatDTO result = replyVisitDataStatService.save(replyVisitDataStatDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, replyVisitDataStatDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reply-visit-data-stats} : get all the replyVisitDataStats.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of replyVisitDataStats in body.
     */
    @GetMapping("/reply-visit-data-stats")
    public ResponseEntity<List<ReplyVisitDataStatDTO>> getAllReplyVisitDataStats(Pageable pageable) {
        log.debug("REST request to get a page of ReplyVisitDataStats");
        Page<ReplyVisitDataStatDTO> page = replyVisitDataStatService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reply-visit-data-stats/:id} : get the "id" replyVisitDataStat.
     *
     * @param id the id of the replyVisitDataStatDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the replyVisitDataStatDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reply-visit-data-stats/{id}")
    public ResponseEntity<ReplyVisitDataStatDTO> getReplyVisitDataStat(@PathVariable Long id) {
        log.debug("REST request to get ReplyVisitDataStat : {}", id);
        Optional<ReplyVisitDataStatDTO> replyVisitDataStatDTO = replyVisitDataStatService.findOne(id);
        return ResponseUtil.wrapOrNotFound(replyVisitDataStatDTO);
    }

    /**
     * {@code DELETE  /reply-visit-data-stats/:id} : delete the "id" replyVisitDataStat.
     *
     * @param id the id of the replyVisitDataStatDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reply-visit-data-stats/{id}")
    public ResponseEntity<Void> deleteReplyVisitDataStat(@PathVariable Long id) {
        log.debug("REST request to delete ReplyVisitDataStat : {}", id);
        replyVisitDataStatService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
