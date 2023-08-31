package com.vusalaxndzde.springbootgraphqlmysql.controller;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import com.vusalaxndzde.springbootgraphqlmysql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AuthorController {

    private final AuthorService authorService;

    @QueryMapping
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @QueryMapping
    public Author findAuthorByAuthorId(@Argument long authorId) {
        return authorService.findAuthorByAuthorId(authorId);
    }

    @QueryMapping
    public int countAuthors() {
        return authorService.countAuthors();
    }

    @MutationMapping
    public Author createAuthor(@Argument String firstName, @Argument String lastName) {
        return authorService.createAuthor(firstName, lastName);
    }

    @MutationMapping
    public Author updateAuthor(@Argument long authorId, @Argument String firstName, @Argument String lastName) {
        return authorService.updateAuthor(authorId, firstName, lastName);
    }

    @MutationMapping
    public boolean deleteAuthor(@Argument long authorId) {
        return authorService.deleteAuthor(authorId);
    }

    @SchemaMapping(typeName = "Query", field = "authors")
    public List<Author> getAuthors() {
        return authorService.authors();
    }

}
