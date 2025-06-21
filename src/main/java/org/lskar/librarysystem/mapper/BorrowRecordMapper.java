package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.lskar.librarysystem.entity.BorrowRecord;
import org.lskar.librarysystem.entity.BorrowRecordQueryParam;

import java.util.List;

@Mapper
public interface BorrowRecordMapper {
    int insertBorrowRecord(BorrowRecord borrowRecord);
    int deleteBorrowRecordByIds(List<String> ids);
    int deleteRecordByReaderId(String id);
    int updateBorrowRecord(BorrowRecord borrowRecord);
    BorrowRecord selectBorrowRecordById(Integer id);
    @Options(useGeneratedKeys = true, keyProperty = "recordId", keyColumn = "record_id")
    List<BorrowRecord> selectBorrowRecordBy(BorrowRecordQueryParam borrowRecordQueryParam);

    int countBorrowRecordByReaderId(String readerId);
}
