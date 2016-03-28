package com.example.ex04.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex04.domain.Book;

/**
 * Created by Alex on 07/03/2015.
 */

public interface BookRepository extends JpaRepository<Book, Long> {
}
