package com.cms.controller;

import com.cms.domain.ScholarEntity;
import com.cms.service.ScholarService;
import com.cms.utility.ApiRespone;
import com.cms.utility.Validator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scholar")
public class ScholarController {

    @Autowired
    ScholarService scholarService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestBody(required = false) Iterable<Long> scholarIds) {
        if (Validator.isEmpty(scholarIds)) {
            return ApiRespone.OK(scholarService.getAll());
        } else {
            return ApiRespone.OK(scholarService.getByIds(scholarIds));
        }
    }

    @GetMapping("{scholarId}")
    public ResponseEntity<?> getById(@PathVariable Long scholarId) {
        Optional<ScholarEntity> entityOptional = scholarService.getById(scholarId);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.NOT_FOUND(scholarId);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ScholarEntity scholarEntity) {
        Optional<ScholarEntity> entityOptional = scholarService.create(scholarEntity);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @PutMapping("{scholarId}")
    public ResponseEntity<?> update(@PathVariable Long scholarId, @RequestBody ScholarEntity scholarEntity) {
        Optional<ScholarEntity> entityOptional = scholarService.update(scholarId, scholarEntity);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @DeleteMapping("{scholarId}")
    public ResponseEntity<?> delete(@PathVariable Long scholarId) {
        if (scholarService.existById(scholarId)) {
            scholarService.delete(scholarId);
            return ApiRespone.OK(scholarId);
        } else {
            return ApiRespone.BAD_REQUEST(scholarId);
        }
    }

}
