package com.cms.controller;

import com.cms.domain.BookEntity;
import com.cms.service.BookService;
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
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestBody(required = false) Iterable<Long> bookIds) {
        if (Validator.isEmpty(bookIds)) {
            return ApiRespone.OK(bookService.getAll());
        } else {
            return ApiRespone.OK(bookService.getByIds(bookIds));
        }
    }

    @GetMapping("{bookId}")
    public ResponseEntity<?> getById(@PathVariable Long bookId) {
        Optional<BookEntity> entityOptional = bookService.getById(bookId);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.NOT_FOUND(bookId);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookEntity bookEntity) {
        Optional<BookEntity> entityOptional = bookService.create(bookEntity);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @PutMapping("{bookId}")
    public ResponseEntity<?> update(@PathVariable Long bookId, @RequestBody BookEntity bookEntity) {
        Optional<BookEntity> entityOptional = bookService.update(bookId, bookEntity);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?> delete(@PathVariable Long bookId) {
        if (bookService.existById(bookId)) {
            bookService.delete(bookId);
            return ApiRespone.OK(bookId);
        } else {
            return ApiRespone.BAD_REQUEST(bookId);
        }
    }

}