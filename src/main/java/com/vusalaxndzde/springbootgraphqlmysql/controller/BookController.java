package com.vusalaxndzde.springbootgraphqlmysql.controller;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Book;
import com.vusalaxndzde.springbootgraphqlmysql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @QueryMapping
    public Book findBookByBookId(@Argument long bookId) {
        return bookService.findBookByBookId(bookId);
    }

    @QueryMapping
    public int countBooks() {
        return bookService.countBooks();
    }

    @MutationMapping
    public Book createBook(@Argument String name, @Argument int pageCount, @Argument Long authorId) {
        return bookService.createBook(name, pageCount, authorId);
    }

    @MutationMapping
    public Book updateBook(@Argument long bookId, @Argument String name, @Argument int pageCount, @Argument Integer authorId) {
        return bookService.updateBook(bookId, name, pageCount, authorId);
    }

    @MutationMapping
    public boolean deleteBook(@Argument long bookId) {
        return bookService.deleteBook(bookId);
    }

}
