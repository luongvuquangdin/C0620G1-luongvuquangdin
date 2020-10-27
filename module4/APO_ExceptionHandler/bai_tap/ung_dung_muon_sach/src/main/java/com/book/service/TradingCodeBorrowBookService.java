package com.book.service;

import com.book.entity.Book;
import com.book.entity.TradingCodeBorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TradingCodeBorrowBookService {
    Page<TradingCodeBorrowBook> findAll(Pageable pageable);
    void create(TradingCodeBorrowBook tradingCodeBorrowBook);
    void deleteById(String id);
    TradingCodeBorrowBook findById(String id);
}
