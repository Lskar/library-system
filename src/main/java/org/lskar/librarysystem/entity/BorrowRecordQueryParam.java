package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "借阅记录分页查询参数")
public class BorrowRecordQueryParam {

    @ApiModelProperty(value = "页码", required = true)
    private Integer page;
    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;
    @ApiModelProperty(value = "用户ID",  required = true)
    private String userId;
    @ApiModelProperty(value = "图书ID")
    private String bookId;
    @ApiModelProperty(value = "管理员ID")
    private String adminId;
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String begin;
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end;


}
