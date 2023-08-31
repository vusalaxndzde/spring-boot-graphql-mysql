package com.vusalaxndzde.springbootgraphqlmysql.service;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import com.vusalaxndzde.springbootgraphqlmysql.entity.Book;
import com.vusalaxndzde.springbootgraphqlmysql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByBookId(long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public int countBooks() {
        return bookRepository.findAll().size();
    }

    public Book createBook(String name, int pageCount, long authorId) {
        Author author = authorService.findAuthorByAuthorId(authorId);

        Book book = Book.builder()
                .name(name)
                .pageCount(pageCount)
                .author(author)
                .build();

        return bookRepository.save(book);
    }

    public boolean deleteBook(long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        bookRepository.delete(book);

        return true;
    }

}
