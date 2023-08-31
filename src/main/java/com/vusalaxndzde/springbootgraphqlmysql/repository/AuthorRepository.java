package com.vusalaxndzde.springbootgraphqlmysql.repository;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
