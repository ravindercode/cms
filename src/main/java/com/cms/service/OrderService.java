package com.cms.service;

import com.cms.domain.BookEntity;
import com.cms.domain.OrderEntity;
import com.cms.domain.ScholarEntity;
import com.cms.mapper.OrderRequest;
import com.cms.repository.OrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements CrudService<OrderEntity, Long> {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookService bookService;
    @Autowired
    ScholarService scholarService;

    //Interface Methods Start
    @Override
    public Iterable<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<OrderEntity> getByIds(Iterable<Long> ids) {
        return orderRepository.findAllById(ids);
    }

    @Override
    public Optional<OrderEntity> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<OrderEntity> create(OrderEntity entity) {
        return Optional.of(orderRepository.save(entity));
    }

    public Optional<OrderEntity> create(OrderRequest orderRequest) {
        Optional<BookEntity> optionalBook = bookService.getById(orderRequest.getBookId());
        Optional<ScholarEntity> optionalScholar = scholarService.getById(orderRequest.getScholarId());
        Optional<OrderEntity> optionalOrder = Optional.empty();
        if (optionalBook.isPresent() && optionalScholar.isPresent()) {
            optionalOrder = create(new OrderEntity(optionalBook.get(), optionalScholar.get()));
        }
        return optionalOrder;
    }

    @Override
    public Optional<OrderEntity> update(Long id, OrderEntity entity) {
        if (orderRepository.existsById(id)) {
            return Optional.of(orderRepository.save(entity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return orderRepository.existsById(id);
    }
    //Interface Methods End


    public void testMethod() {
        System.out.println("A");
//        orderRepository.findByScholar(new ScholarEntity());
    }

}
