package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    void updateBookById(Book book);
    void insertBook(Book book);
    void deleteBookByIds(List ids);
    Book selectBookById(Integer id);
    List<Book> selectBookBy(Book book);
}
