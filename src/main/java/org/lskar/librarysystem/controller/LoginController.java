package org.lskar.librarysystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.lskar.librarysystem.entity.LoginInfo;
import org.lskar.librarysystem.entity.Reader;
import org.lskar.librarysystem.entity.ResponseResult;
import org.lskar.librarysystem.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "登录控制")
public class LoginController {

    @Autowired
    private ReaderService readerService;
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    @ApiImplicitParam(name = "reader",value = "读者对象",required = true,dataType = "Reader",paramType = "body")
    public ResponseResult<LoginInfo> login(@RequestBody @Valid Reader reader) {

        log.info("登录用户：{}", reader);
        LoginInfo loginInfo = readerService.login(reader);
        return ResponseResult.success(loginInfo);
    }

}
