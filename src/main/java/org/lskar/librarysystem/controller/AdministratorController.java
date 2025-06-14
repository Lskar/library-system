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

    @GetMapping("/{id}")
    @ApiOperation(value = "获取管理员",notes = "获取管理员的详细信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id",value = "管理员ID",required = true,dataType = "String",paramType = "path")
    public ResponseResult<Administrator> getAdministratorById(@PathVariable String id) {
        return ResponseResult.success(administratorService.selectById(id));
    }
    @PutMapping
    @ApiOperation(value = "更新管理员",notes = "更新管理员",httpMethod = "PUT")
    @ApiImplicitParam(name = "administrator",value = "管理员对象",required = true,dataType = "Administrator",paramType = "body")
    public ResponseResult<Void> updateAdministrator(@RequestBody Administrator administrator) {
        administratorService.update(administrator);
        return ResponseResult.success();
    }

    @PostMapping
    @ApiOperation(value = "添加管理员",notes = "添加管理员",httpMethod = "POST")
    @ApiImplicitParam(name = "administrator",value = "管理员对象",required = true,dataType = "Administrator",paramType = "body")
    public ResponseResult<Void> addAdministrator(@RequestBody Administrator administrator) {
        administratorService.insert(administrator);
        return ResponseResult.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除管理员",notes = "批量删除管理员",httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids",value = "管理员ID列表",required = true,dataType = "List",paramType = "query")
    public ResponseResult<Void> deleteAdministrator(@RequestParam List<String> ids) {
        administratorService.delete(ids);
        return ResponseResult.success();
    }




}
