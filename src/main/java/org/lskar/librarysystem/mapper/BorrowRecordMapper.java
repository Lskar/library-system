package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowRecordMapper {
    void insertBorrowRecord();
    void deleteBorrowRecordByIds(Integer[] ids);
    void updateBorrowRecord();
    void selectBorrowRecordById();
}
