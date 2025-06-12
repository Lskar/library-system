package org.lskar.librarysystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BookQueryParam;
import org.lskar.librarysystem.entity.PageResult;
import org.lskar.librarysystem.exception.NotFoundException;
import org.lskar.librarysystem.mapper.BookMapper;
import org.lskar.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageResult<Book> selectBookByQueryParam(BookQueryParam bookQueryParam) {
        PageHelper.startPage(bookQueryParam.getPage(),bookQueryParam.getPageSize());
        Page<Book> pageInfo = (Page<Book>)bookMapper.selectBookBy(bookQueryParam);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }

    @Override
    public Book getBookById(String id) {
        return null;
    }

    @Override
    public void insert(Book book) {
        int result =bookMapper.insertBook(book);
        if(result == 0){
            throw new NotFoundException("插入数据失败");
        }
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(String id) {

    }
}
