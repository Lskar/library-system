package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.lskar.librarysystem.entity.Book;
import org.lskar.librarysystem.entity.BookQueryParam;
import org.lskar.librarysystem.entity.PageResult;
import org.lskar.librarysystem.entity.ResponseResult;
import org.lskar.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/books")
@Api(tags = "图书控制")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @ApiOperation(value = "获取图书列表", notes = "获取所有图书的详细信息", httpMethod = "GET")
    public ResponseResult<PageResult<Book>> page(BookQueryParam bookQueryParam) {
        PageResult<Book> bookPageResult = bookService.selectBookByQueryParam(bookQueryParam);
        return ResponseResult.success(bookPageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取图书", notes = "获取指定图书的详细信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "String", paramType = "path")
    public ResponseResult<Book> getBookById(@PathVariable String id) {
        return ResponseResult.success(bookService.getBookById(id));
    }

    @PostMapping
    @ApiOperation(value = "添加图书", notes = "添加图书", httpMethod = "POST")
    @ApiImplicitParam(name = "book", value = "图书对象", required = true, dataType = "Book", paramType = "body")
    public ResponseResult<Void> addBook(@RequestBody Book book) {
        bookService.insert(book);
        return ResponseResult.success();
    }

    @PutMapping
    @ApiOperation(value = "更新图书", notes = "更新图书", httpMethod = "PUT")
    @ApiImplicitParam(name = "book", value = "图书对象", required = true, dataType = "Book", paramType = "body")
    public ResponseResult<Void> updateBook(@RequestBody Book book) {
        bookService.update(book);
        return ResponseResult.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除图书", notes = "删除指定图书", httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids", value = "图书ID列表", required = true, dataType = "List", paramType = "query")
    public ResponseResult<Void> deleteBook(@RequestParam List<String> ids) {
        bookService.delete(ids);
        return ResponseResult.success();
    }


}
