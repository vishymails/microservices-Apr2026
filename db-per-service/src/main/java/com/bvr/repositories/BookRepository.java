package com.bvr.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bvr.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.name = :name")
    List<Book> findByName(String name);

}
