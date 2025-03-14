package com.cms.service;

import com.cms.domain.BookEntity;
import com.cms.domain.OrderEntity;
import com.cms.domain.ScholarEntity;
import com.cms.mapper.order.CreateRequest;
import com.cms.mapper.order.UpdateRequest;
import com.cms.repository.OrderRepository;
import java.time.LocalDate;
import java.util.Objects;
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

    public Optional<OrderEntity> create(CreateRequest orderRequest) {
        Optional<BookEntity> optionalBook = bookService.getById(orderRequest.getBookId());
        Optional<ScholarEntity> optionalScholar = scholarService.getById(orderRequest.getScholarId());
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not present");
        }
        if (optionalScholar.isEmpty()) {
            throw new RuntimeException("Scholar not present");
        }
        return create(new OrderEntity(optionalBook.get(), optionalScholar.get()));
    }

    public Optional<OrderEntity> returnOrder(Long id, UpdateRequest updateRequest) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not present");
        }
        OrderEntity order = optionalOrder.get();
        order.setReturnOn(updateRequest.getReturnOn());
        return Optional.of(orderRepository.save(order));
    }

    public Optional<OrderEntity> reorder(Long id, UpdateRequest updateRequest) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Existing Order not present");
        }
        OrderEntity order = optionalOrder.get();
        order.setReturnOn(Objects.nonNull(updateRequest.getReturnOn()) ? updateRequest.getReturnOn() : LocalDate.now());
        orderRepository.save(order);

        LocalDate rePlacedOn = Objects.nonNull(updateRequest.getPlacedOn()) ? updateRequest.getPlacedOn() : LocalDate.now();
        CreateRequest createRequest = new CreateRequest(order.getBookEntity().getId(), order.getScholarEntity().getId(), rePlacedOn);
        return create(createRequest);
    }

    public void testMethod() {
        System.out.println("A");
//        orderRepository.findByScholar(new ScholarEntity());
    }

}
