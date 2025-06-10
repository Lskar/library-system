package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.lskar.librarysystem.entity.Administrator;
import org.lskar.librarysystem.entity.ResponseResult;
import org.lskar.librarysystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
@Api(tags = "管理员控制")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    @ApiOperation(value = "获取管理员列表",notes = "获取所有管理员的详细信息",httpMethod = "GET")
    public ResponseResult<List<Administrator>> list() {
        return ResponseResult.success(administratorService.list());
    }
    @PutMapping
    @ApiOperation(value = "更新管理员",notes = "更新管理员",httpMethod = "PUT")
    @ApiImplicitParam(name = "administrator",value = "管理员对象",required = true,dataType = "Administrator",paramType = "body")
    public ResponseResult<Void> updateAdministrator(@RequestBody Administrator administrator) {
        return ResponseResult.success();
    }

    @PostMapping
    @ApiOperation(value = "添加管理员",notes = "添加管理员",httpMethod = "POST")
    @ApiImplicitParam(name = "administrator",value = "管理员对象",required = true,dataType = "Administrator",paramType = "body")
    public ResponseResult<Void> addAdministrator(@RequestBody Administrator administrator) {
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除管理员",notes = "删除指定管理员",httpMethod = "DELETE")
    @ApiImplicitParam(name = "id",value = "管理员ID",required = true,dataType = "String",paramType = "path")
    public ResponseResult<Void> deleteAdministrator(@PathVariable String id) {
        return ResponseResult.success();
    }




}
