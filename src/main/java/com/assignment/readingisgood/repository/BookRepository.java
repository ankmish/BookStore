package com.assignment.readingisgood.repository;

import com.assignment.readingisgood.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
