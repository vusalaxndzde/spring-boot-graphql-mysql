package com.vusalaxndzde.springbootgraphqlmysql.repository;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
