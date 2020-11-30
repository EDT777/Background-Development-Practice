package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.UserContentCollectionService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.UserContentCollectionDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.UserContentCollection}.
 */
@RestController
@RequestMapping("/api")
public class UserContentCollectionResource {

    private final Logger log = LoggerFactory.getLogger(UserContentCollectionResource.class);

    private static final String ENTITY_NAME = "userContentCollection";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserContentCollectionService userContentCollectionService;

    public UserContentCollectionResource(UserContentCollectionService userContentCollectionService) {
        this.userContentCollectionService = userContentCollectionService;
    }

    /**
     * {@code POST  /user-content-collections} : Create a new userContentCollection.
     *
     * @param userContentCollectionDTO the userContentCollectionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userContentCollectionDTO, or with status {@code 400 (Bad Request)} if the userContentCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-content-collections")
    public ResponseEntity<UserContentCollectionDTO> createUserContentCollection(@RequestBody UserContentCollectionDTO userContentCollectionDTO) throws URISyntaxException {
        log.debug("REST request to save UserContentCollection : {}", userContentCollectionDTO);
        if (userContentCollectionDTO.getId() != null) {
            throw new BadRequestAlertException("A new userContentCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserContentCollectionDTO result = userContentCollectionService.save(userContentCollectionDTO);
        return ResponseEntity.created(new URI("/api/user-content-collections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-content-collections} : Updates an existing userContentCollection.
     *
     * @param userContentCollectionDTO the userContentCollectionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userContentCollectionDTO,
     * or with status {@code 400 (Bad Request)} if the userContentCollectionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userContentCollectionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-content-collections")
    public ResponseEntity<UserContentCollectionDTO> updateUserContentCollection(@RequestBody UserContentCollectionDTO userContentCollectionDTO) throws URISyntaxException {
        log.debug("REST request to update UserContentCollection : {}", userContentCollectionDTO);
        if (userContentCollectionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserContentCollectionDTO result = userContentCollectionService.save(userContentCollectionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userContentCollectionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-content-collections} : get all the userContentCollections.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userContentCollections in body.
     */
    @GetMapping("/user-content-collections")
    public ResponseEntity<List<UserContentCollectionDTO>> getAllUserContentCollections(Pageable pageable) {
        log.debug("REST request to get a page of UserContentCollections");
        Page<UserContentCollectionDTO> page = userContentCollectionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-content-collections/:id} : get the "id" userContentCollection.
     *
     * @param id the id of the userContentCollectionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userContentCollectionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-content-collections/{id}")
    public ResponseEntity<UserContentCollectionDTO> getUserContentCollection(@PathVariable Long id) {
        log.debug("REST request to get UserContentCollection : {}", id);
        Optional<UserContentCollectionDTO> userContentCollectionDTO = userContentCollectionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userContentCollectionDTO);
    }

    /**
     * {@code DELETE  /user-content-collections/:id} : delete the "id" userContentCollection.
     *
     * @param id the id of the userContentCollectionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-content-collections/{id}")
    public ResponseEntity<Void> deleteUserContentCollection(@PathVariable Long id) {
        log.debug("REST request to delete UserContentCollection : {}", id);
        userContentCollectionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
