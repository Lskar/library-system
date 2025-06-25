package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.lskar.librarysystem.entity.Reader;
import org.lskar.librarysystem.entity.ResponseResult;
import org.lskar.librarysystem.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@Api(tags = "读者控制")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    @ApiOperation(value = "获取读者列表",notes = "获取所有读者的详细信息",httpMethod = "GET")
    public ResponseResult<List<Reader>> list() {
        return ResponseResult.success(readerService.list());
    }

    //非rest风格的使用
    //省略@RequestParam
    //在url中的?后面添加参数即可使用
    //名称相同时可以省略

    @GetMapping("/{id}")
    @ApiOperation(value = "获取读者",notes = "获取指定读者的详细信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id",value = "读者ID",required = true,dataType = "String",paramType = "path")
    public ResponseResult<Reader> getReaderById(@PathVariable String id) {
        return ResponseResult.success(readerService.getReaderById(id));
    }

    @PostMapping
    @ApiOperation(value = "添加读者",notes = "添加读者",httpMethod = "POST")
    @ApiImplicitParam(name = "reader",value = "读者对象",required = true,dataType = "Reader",paramType = "body")
    public ResponseResult<Void> addReader(@RequestBody @Valid Reader reader) {
        readerService.insert(reader);
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除读者",notes = "删除指定读者",httpMethod = "DELETE")
    @ApiImplicitParam(name = "id",value = "读者ID",required = true,dataType = "String",paramType = "path")
    public ResponseResult<Void> deleteReader(@PathVariable String id) {
        readerService.delete(id);
        return ResponseResult.success();
    }

    @PutMapping
    @ApiOperation(value = "更新读者",notes = "更新读者",httpMethod = "PUT")
    @ApiImplicitParam(name = "reader",value = "读者对象",required = true,dataType = "Reader",paramType = "body")
    public ResponseResult<Void> updateReader(@RequestBody @Valid Reader reader) {
        readerService.update(reader);
        return ResponseResult.success();
    }


}
