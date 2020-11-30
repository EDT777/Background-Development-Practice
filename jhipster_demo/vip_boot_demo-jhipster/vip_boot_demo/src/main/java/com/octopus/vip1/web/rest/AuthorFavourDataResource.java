package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.AuthorFavourDataService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.AuthorFavourDataDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.AuthorFavourData}.
 */
@RestController
@RequestMapping("/api")
public class AuthorFavourDataResource {

    private final Logger log = LoggerFactory.getLogger(AuthorFavourDataResource.class);

    private static final String ENTITY_NAME = "authorFavourData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AuthorFavourDataService authorFavourDataService;

    public AuthorFavourDataResource(AuthorFavourDataService authorFavourDataService) {
        this.authorFavourDataService = authorFavourDataService;
    }

    /**
     * {@code POST  /author-favour-data} : Create a new authorFavourData.
     *
     * @param authorFavourDataDTO the authorFavourDataDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new authorFavourDataDTO, or with status {@code 400 (Bad Request)} if the authorFavourData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/author-favour-data")
    public ResponseEntity<AuthorFavourDataDTO> createAuthorFavourData(@RequestBody AuthorFavourDataDTO authorFavourDataDTO) throws URISyntaxException {
        log.debug("REST request to save AuthorFavourData : {}", authorFavourDataDTO);
        if (authorFavourDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new authorFavourData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AuthorFavourDataDTO result = authorFavourDataService.save(authorFavourDataDTO);
        return ResponseEntity.created(new URI("/api/author-favour-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /author-favour-data} : Updates an existing authorFavourData.
     *
     * @param authorFavourDataDTO the authorFavourDataDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated authorFavourDataDTO,
     * or with status {@code 400 (Bad Request)} if the authorFavourDataDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the authorFavourDataDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/author-favour-data")
    public ResponseEntity<AuthorFavourDataDTO> updateAuthorFavourData(@RequestBody AuthorFavourDataDTO authorFavourDataDTO) throws URISyntaxException {
        log.debug("REST request to update AuthorFavourData : {}", authorFavourDataDTO);
        if (authorFavourDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AuthorFavourDataDTO result = authorFavourDataService.save(authorFavourDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, authorFavourDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /author-favour-data} : get all the authorFavourData.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of authorFavourData in body.
     */
    @GetMapping("/author-favour-data")
    public ResponseEntity<List<AuthorFavourDataDTO>> getAllAuthorFavourData(Pageable pageable) {
        log.debug("REST request to get a page of AuthorFavourData");
        Page<AuthorFavourDataDTO> page = authorFavourDataService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /author-favour-data/:id} : get the "id" authorFavourData.
     *
     * @param id the id of the authorFavourDataDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the authorFavourDataDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/author-favour-data/{id}")
    public ResponseEntity<AuthorFavourDataDTO> getAuthorFavourData(@PathVariable Long id) {
        log.debug("REST request to get AuthorFavourData : {}", id);
        Optional<AuthorFavourDataDTO> authorFavourDataDTO = authorFavourDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(authorFavourDataDTO);
    }

    /**
     * {@code DELETE  /author-favour-data/:id} : delete the "id" authorFavourData.
     *
     * @param id the id of the authorFavourDataDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/author-favour-data/{id}")
    public ResponseEntity<Void> deleteAuthorFavourData(@PathVariable Long id) {
        log.debug("REST request to delete AuthorFavourData : {}", id);
        authorFavourDataService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
