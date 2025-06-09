package org.lskar.librarysystem.service.impl;

import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.mapper.BookMapper;
import org.lskar.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return List.of();
    }

    @Override
    public Book getBookById(String id) {
        return null;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(String id) {

    }
}
