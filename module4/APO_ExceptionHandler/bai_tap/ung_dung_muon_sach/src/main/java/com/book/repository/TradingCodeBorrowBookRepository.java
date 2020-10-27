package com.book.repository;

import com.book.entity.TradingCodeBorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingCodeBorrowBookRepository extends JpaRepository<TradingCodeBorrowBook,String> {
}
