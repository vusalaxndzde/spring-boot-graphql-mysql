package com.vusalaxndzde.springbootgraphqlmysql.service;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import com.vusalaxndzde.springbootgraphqlmysql.entity.Book;
import com.vusalaxndzde.springbootgraphqlmysql.repository.AuthorRepository;
import com.vusalaxndzde.springbootgraphqlmysql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorByAuthorId(long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public Author findAuthorByBook(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow();
    }

    public int countAuthors() {
        return authorRepository.findAll().size();
    }

    public Author createAuthor(String firstName, String lastName) {
        Author author = Author.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        return authorRepository.save(author);
    }

    public Author updateAuthor(long authorId, String firstName, String lastName) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }

    public boolean deleteAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.getBooks().forEach(book -> {
                            book.setAuthor(null);
                            bookRepository.save(book);
                        });
        authorRepository.delete(author);

        return true;
    }

    public List<Author> authors() {
        return authorRepository.findAll();
    }

}
