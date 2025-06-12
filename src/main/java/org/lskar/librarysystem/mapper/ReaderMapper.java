package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Reader;

import java.util.List;

@Mapper
public interface ReaderMapper {

    int insertReader();
    int deleteReaderByIds(Integer[] ids);
    int updateReader(Reader reader);
    Reader selectReaderById(Integer id);

}
