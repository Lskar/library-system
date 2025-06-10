package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.lskar.librarysystem.entity.BorrowRecord;
import org.lskar.librarysystem.entity.ResponseResult;
import org.lskar.librarysystem.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowRecords")
@Api(tags = "借阅控制")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @PutMapping
    @ApiOperation(value = "更新借阅记录", notes = "更新借阅记录", httpMethod = "PUT")
    @ApiImplicitParam(name = "borrowRecord", value = "借阅记录对象", required = true, dataType = "BorrowRecord", paramType = "body")
    public ResponseResult<Void> updateBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        return ResponseResult.success();
    }

    @PostMapping
    @ApiOperation(value = "添加借阅记录", notes = "添加借阅记录", httpMethod = "POST")
    @ApiImplicitParam(name = "borrowRecord", value = "借阅记录对象", required = true, dataType = "BorrowRecord", paramType = "body")
    public ResponseResult<Void> addBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        return ResponseResult.success();
    }


}
