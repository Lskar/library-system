package org.lskar.librarysystem.service;

import org.lskar.librarysystem.entity.BorrowRecord;

public interface BorrowRecordService {

    void insert(BorrowRecord borrowRecord);

    void update(BorrowRecord borrowRecord);

}
