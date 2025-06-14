package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BorrowRecordMapper {
    void insertBorrowRecord();
    void deleteBorrowRecordByIds(List ids);
    void updateBorrowRecord();
    void selectBorrowRecordById();
}
