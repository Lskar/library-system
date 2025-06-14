package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BookQueryParam;
import org.lskar.librarysystem.entity.PageResult;

import java.util.List;

public interface BookService {

    PageResult<Book> selectBookByQueryParam(BookQueryParam bookQueryParam);
    Book getBookById(String id);
    void insert(Book book);
    void update(Book book);
    void delete(List<String> ids);
}
