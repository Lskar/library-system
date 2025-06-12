package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BookQueryParam;

import java.util.List;

@Mapper
public interface BookMapper {

    void updateBookById(Book book);
    int insertBook(Book book);
    void deleteBookByIds(Integer[] ids);
    Book selectBookById(Integer id);
    List<Book> selectBookBy(BookQueryParam bookQueryParam);
}
