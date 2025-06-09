package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> list();
    Book getBookById(String id);
    void insert(Book book);
    void update(Book book);
    void delete(String id);
}
