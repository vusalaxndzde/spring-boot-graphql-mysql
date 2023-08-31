package com.vusalaxndzde.springbootgraphqlmysql.service;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import com.vusalaxndzde.springbootgraphqlmysql.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorByAuthorId(long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public int countAuthors() {
        return authorRepository.findAll().size();
    }

}
