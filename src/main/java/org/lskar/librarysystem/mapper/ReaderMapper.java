package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Reader;

import java.util.List;

@Mapper
public interface ReaderMapper {

    int insertReader(Reader reader);
    int deleteReaderById(String id);
    int updateReader(Reader reader);
    Reader selectReaderById(String id);
    List<Reader> selectAllReader();
}
