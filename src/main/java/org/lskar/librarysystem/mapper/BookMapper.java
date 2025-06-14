package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BookQueryParam;

import java.util.List;

@Mapper
public interface BookMapper {

    int updateBookById(Book book);
    int insertBook(Book book);
    int deleteBookByIds(List<String> ids);
    Book selectBookById(String id);
    List<Book> selectBookBy(BookQueryParam bookQueryParam);
}
