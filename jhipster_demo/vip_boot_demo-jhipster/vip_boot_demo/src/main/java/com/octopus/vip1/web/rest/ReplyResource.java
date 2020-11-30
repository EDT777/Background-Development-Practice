package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.ReplyService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.ReplyDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.Reply}.
 */
@RestController
@RequestMapping("/api")
public class ReplyResource {

    private final Logger log = LoggerFactory.getLogger(ReplyResource.class);

    private static final String ENTITY_NAME = "reply";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReplyService replyService;

    public ReplyResource(ReplyService replyService) {
        this.replyService = replyService;
    }

    /**
     * {@code POST  /replies} : Create a new reply.
     *
     * @param replyDTO the replyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new replyDTO, or with status {@code 400 (Bad Request)} if the reply has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/replies")
    public ResponseEntity<ReplyDTO> createReply(@RequestBody ReplyDTO replyDTO) throws URISyntaxException {
        log.debug("REST request to save Reply : {}", replyDTO);
        if (replyDTO.getId() != null) {
            throw new BadRequestAlertException("A new reply cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReplyDTO result = replyService.save(replyDTO);
        return ResponseEntity.created(new URI("/api/replies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /replies} : Updates an existing reply.
     *
     * @param replyDTO the replyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated replyDTO,
     * or with status {@code 400 (Bad Request)} if the replyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the replyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/replies")
    public ResponseEntity<ReplyDTO> updateReply(@RequestBody ReplyDTO replyDTO) throws URISyntaxException {
        log.debug("REST request to update Reply : {}", replyDTO);
        if (replyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReplyDTO result = replyService.save(replyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, replyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /replies} : get all the replies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of replies in body.
     */
    @GetMapping("/replies")
    public ResponseEntity<List<ReplyDTO>> getAllReplies(Pageable pageable) {
        log.debug("REST request to get a page of Replies");
        Page<ReplyDTO> page = replyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /replies/:id} : get the "id" reply.
     *
     * @param id the id of the replyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the replyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/replies/{id}")
    public ResponseEntity<ReplyDTO> getReply(@PathVariable Long id) {
        log.debug("REST request to get Reply : {}", id);
        Optional<ReplyDTO> replyDTO = replyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(replyDTO);
    }

    /**
     * {@code DELETE  /replies/:id} : delete the "id" reply.
     *
     * @param id the id of the replyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/replies/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        log.debug("REST request to delete Reply : {}", id);
        replyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
