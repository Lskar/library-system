package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.BorrowRecord;
import org.lskar.librarysystem.entity.BorrowRecordQueryParam;
import org.lskar.librarysystem.entity.PageResult;

public interface BorrowRecordService {

    void insert(BorrowRecord borrowRecord);

    void update(BorrowRecord borrowRecord);

    PageResult<BorrowRecord> selectBorrowRecordByQueryParam(BorrowRecordQueryParam queryParam);


    void returnBook(Integer recordId);
}
