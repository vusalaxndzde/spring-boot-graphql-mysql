package com.vusalaxndzde.springbootgraphqlmysql;

import com.vusalaxndzde.springbootgraphqlmysql.entity.Author;
import com.vusalaxndzde.springbootgraphqlmysql.entity.Book;
import com.vusalaxndzde.springbootgraphqlmysql.repository.AuthorRepository;
import com.vusalaxndzde.springbootgraphqlmysql.repository.BookRepository;
import com.vusalaxndzde.springbootgraphqlmysql.service.AuthorService;
import com.vusalaxndzde.springbootgraphqlmysql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringBootGraphqlMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlMysqlApplication.class, args);
	}

	public final BookRepository bookRepository;
	public final AuthorRepository authorRepository;

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			Author author = Author.builder()
//					.firstName("Albert")
//					.lastName("Camus")
//					.build();
//
//			authorRepository.save(author);
//
//			Book book = Book.builder()
//					.name("The Stranger")
//					.pageCount(120)
//					.author(author)
//					.build();
//
//			bookRepository.save(book);
//		};
//	}

}
