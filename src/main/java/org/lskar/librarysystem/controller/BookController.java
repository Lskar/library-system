package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.lskar.librarysystem.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(tags = "图书控制")
public class BookController {


    @GetMapping
    @ApiOperation(value = "获取图书列表",notes = "获取所有图书的详细信息",httpMethod = "GET")
    public List<Book> list() {
        return null;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取图书",notes = "获取指定图书的详细信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id",value = "图书ID",required = true,dataType = "Integer",paramType = "path")
    public Book getBookById(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    @ApiOperation(value = "添加图书",notes = "添加图书",httpMethod = "POST")
    @ApiImplicitParam(name = "book",value = "图书对象",required = true,dataType = "Book",paramType = "body")
    public void addBook(@RequestBody Book book) {

    }



}
