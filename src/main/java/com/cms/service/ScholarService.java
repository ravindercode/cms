package com.cms.service;

import com.cms.domain.ScholarEntity;
import com.cms.repository.ScholarRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarService implements CrudService<ScholarEntity, Long> {

    @Autowired
    ScholarRepository scholarRepository;

    //Interface Methods Start
    @Override
    public Iterable<ScholarEntity> getAll() {
        return scholarRepository.findAll();
    }

    @Override
    public Iterable<ScholarEntity> getByIds(Iterable<Long> ids) {
        return scholarRepository.findAllById(ids);
    }

    @Override
    public Optional<ScholarEntity> getById(Long id) {
        return scholarRepository.findById(id);
    }

    @Override
    public Optional<ScholarEntity> create(ScholarEntity entity) {
        return Optional.of(scholarRepository.save(entity));
    }

    @Override
    public Optional<ScholarEntity> update(Long id, ScholarEntity entity) {
        if (scholarRepository.existsById(id)) {
            return Optional.of(scholarRepository.save(entity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        scholarRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return scholarRepository.existsById(id);
    }
    //Interface Methods End

    public void testMethod() {
        scholarRepository.findByName("TestName");
    }

}
