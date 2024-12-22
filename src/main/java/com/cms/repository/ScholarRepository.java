package com.cms.repository;

import com.cms.domain.ScholarEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarRepository extends JpaRepository<ScholarEntity, Long> {

    Optional<ScholarEntity> findByName(String name);

}
