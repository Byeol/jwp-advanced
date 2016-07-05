package org.nhnnext.web;

import lombok.RequiredArgsConstructor;
import org.nhnnext.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public abstract class RepositoryEntityController<T extends BaseEntity<T, ID>, ID extends Serializable> {

    private static final String BASE_MAPPING = "";
    private final CrudRepository<T, ID> repository;

    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public ResponseEntity<?> getCollectionResource() {
        Iterable<T> entities = repository.findAll();
        return ResponseEntity.ok(entities);
    }

    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.POST)
    public ResponseEntity<?> postCollectionResource(@RequestBody T entity) {
        repository.save(entity);

        URI location = UriComponentsBuilder.fromPath(entity.getId().toString()).build().toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @RequestMapping(value = BASE_MAPPING + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getItemResource(@PathVariable ID id) {
        T domainObject = repository.findOne(id);

        if (domainObject == null) {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(domainObject);
    }

    @RequestMapping(value = BASE_MAPPING + "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> patchItemResource(@PathVariable ID id, @RequestBody T newEntity) {
        T domainObject = repository.findOne(id);

        if (domainObject == null) {
            throw new ResourceNotFoundException();
        }

        domainObject.update(newEntity);
        repository.save(domainObject);

        return ResponseEntity.ok(domainObject);
    }

    @RequestMapping(value = BASE_MAPPING + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteItemResource(@PathVariable ID id) {
        T domainObject = repository.findOne(id);

        if (domainObject == null) {
            throw new ResourceNotFoundException();
        }

        repository.delete(domainObject);

        return ResponseEntity.noContent().build();
    }

}