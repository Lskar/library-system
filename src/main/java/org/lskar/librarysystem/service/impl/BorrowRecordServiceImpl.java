package org.lskar.librarysystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BorrowRecord;
import org.lskar.librarysystem.entity.BorrowRecordQueryParam;
import org.lskar.librarysystem.entity.PageResult;
import org.lskar.librarysystem.enums.StatusEnum;
import org.lskar.librarysystem.exception.IsBorrowedException;
import org.lskar.librarysystem.exception.NotFoundException;
import org.lskar.librarysystem.exception.TimeEarlyException;
import org.lskar.librarysystem.mapper.BorrowRecordMapper;
import org.lskar.librarysystem.service.BookService;
import org.lskar.librarysystem.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private BookService bookService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(BorrowRecord borrowRecord) {
        Book book = bookService.getBookById(borrowRecord.getBookId());
        if(book.getStatus() != StatusEnum.ACCEPT){
            throw new IsBorrowedException("图书状态异常");
        }
        book.setStatus(StatusEnum.REFUSE);
        bookService.update(book);
        borrowRecord.setAdminId(book.getAdminId());
        borrowRecord.setBorrowDate(LocalDate.now());
        int result = borrowRecordMapper.insertBorrowRecord(borrowRecord);
        if (result == 0) {
            throw new NotFoundException("插入数据失败");
        }
    }

    @Override
    public void update(BorrowRecord borrowRecord) {

        if(borrowRecord.getReturnDate().isBefore(borrowRecord.getBorrowDate())){
            throw new TimeEarlyException("归还时间不能早于借书时间");
        }
        int result = borrowRecordMapper.updateBorrowRecord(borrowRecord);
        if (result == 0) {
            throw new NotFoundException("更新数据失败");
        }
    }

    @Override
    public PageResult<BorrowRecord> selectBorrowRecordByQueryParam(BorrowRecordQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getPageSize());
        Page<BorrowRecord> pageInfo = (Page<BorrowRecord>)borrowRecordMapper.selectBorrowRecordBy(queryParam);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }
}
