package com.book.service;

import com.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    void update(Book book) throws Exception;
    void create(Book book);
    Book findById(Integer id);
}
