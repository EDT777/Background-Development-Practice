package com.octopus.vip1.web.rest;

import com.octopus.vip1.service.ResourceItemService;
import com.octopus.vip1.web.rest.errors.BadRequestAlertException;
import com.octopus.vip1.service.dto.ResourceItemDTO;

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
 * REST controller for managing {@link com.octopus.vip1.domain.ResourceItem}.
 */
@RestController
@RequestMapping("/api")
public class ResourceItemResource {

    private final Logger log = LoggerFactory.getLogger(ResourceItemResource.class);

    private static final String ENTITY_NAME = "resourceItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResourceItemService resourceItemService;

    public ResourceItemResource(ResourceItemService resourceItemService) {
        this.resourceItemService = resourceItemService;
    }

    /**
     * {@code POST  /resource-items} : Create a new resourceItem.
     *
     * @param resourceItemDTO the resourceItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resourceItemDTO, or with status {@code 400 (Bad Request)} if the resourceItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/resource-items")
    public ResponseEntity<ResourceItemDTO> createResourceItem(@RequestBody ResourceItemDTO resourceItemDTO) throws URISyntaxException {
        log.debug("REST request to save ResourceItem : {}", resourceItemDTO);
        if (resourceItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new resourceItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResourceItemDTO result = resourceItemService.save(resourceItemDTO);
        return ResponseEntity.created(new URI("/api/resource-items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /resource-items} : Updates an existing resourceItem.
     *
     * @param resourceItemDTO the resourceItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resourceItemDTO,
     * or with status {@code 400 (Bad Request)} if the resourceItemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resourceItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/resource-items")
    public ResponseEntity<ResourceItemDTO> updateResourceItem(@RequestBody ResourceItemDTO resourceItemDTO) throws URISyntaxException {
        log.debug("REST request to update ResourceItem : {}", resourceItemDTO);
        if (resourceItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ResourceItemDTO result = resourceItemService.save(resourceItemDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resourceItemDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /resource-items} : get all the resourceItems.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resourceItems in body.
     */
    @GetMapping("/resource-items")
    public ResponseEntity<List<ResourceItemDTO>> getAllResourceItems(Pageable pageable) {
        log.debug("REST request to get a page of ResourceItems");
        Page<ResourceItemDTO> page = resourceItemService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /resource-items/:id} : get the "id" resourceItem.
     *
     * @param id the id of the resourceItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resourceItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/resource-items/{id}")
    public ResponseEntity<ResourceItemDTO> getResourceItem(@PathVariable Long id) {
        log.debug("REST request to get ResourceItem : {}", id);
        Optional<ResourceItemDTO> resourceItemDTO = resourceItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resourceItemDTO);
    }

    /**
     * {@code DELETE  /resource-items/:id} : delete the "id" resourceItem.
     *
     * @param id the id of the resourceItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/resource-items/{id}")
    public ResponseEntity<Void> deleteResourceItem(@PathVariable Long id) {
        log.debug("REST request to delete ResourceItem : {}", id);
        resourceItemService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
