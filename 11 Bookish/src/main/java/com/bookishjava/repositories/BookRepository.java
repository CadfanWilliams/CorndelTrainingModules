package com.bookishjava.repositories;
import java.util.List;
import java.util.Optional;
import com.bookishjava.models.database.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    List<Book> findByAuthor(String author);

}
