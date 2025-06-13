package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Reader;

@Mapper
public interface ReaderMapper {
    void insertReader();
    void updateReader();
    void selectReaderById();
    void deleteReader();




}
