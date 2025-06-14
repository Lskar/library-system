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
        Book book = bookMapper.selectBookById(id);
        if(book == null){
            throw new NotFoundException("未找到编号为"+id+"的图书");
        }
        return book;
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
        int result =bookMapper.updateBookById(book);
        if(result == 0){
            throw new NotFoundException("更新数据失败");
        }
    }

    @Override
    public void delete(List<String> ids) {
        int result =bookMapper.deleteBookByIds(ids);
        if(result == 0){
            throw new NotFoundException("批量删除数据失败");
        }
    }
}
