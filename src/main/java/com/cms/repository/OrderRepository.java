package com.cms.repository;

import com.cms.domain.BookEntity;
import com.cms.domain.OrderEntity;
import com.cms.domain.ScholarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Iterable<OrderEntity> findByScholarEntity(ScholarEntity scholarEntity);

    Iterable<OrderEntity> findByBookEntity(BookEntity bookEntity);

}
