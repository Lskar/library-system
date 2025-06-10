package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Book;

@Mapper
public interface BookMapper {

    void updateById(Book book);


}
