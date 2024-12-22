package com.cms.service;

import com.cms.domain.BookEntity;
import com.cms.repository.BookRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements CrudService<BookEntity, Long> {

    @Autowired
    BookRepository bookRepository;

    //Interface Methods Start
    @Override
    public Iterable<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<BookEntity> getByIds(Iterable<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public Optional<BookEntity> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<BookEntity> create(BookEntity entity) {
        return Optional.of(bookRepository.save(entity));
    }

    @Override
    public Optional<BookEntity> update(Long id, BookEntity entity) {
        if (bookRepository.existsById(id)) {
            return Optional.of(bookRepository.save(entity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return bookRepository.existsById(id);
    }
    //Interface Methods End

}
