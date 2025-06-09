package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "借阅记录")
public class BorrowRecord {

    @ApiModelProperty(value = "借阅记录ID")
    private Integer recordId;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "图书ID", required = true)
    private String bookId;
    @ApiModelProperty(value = "管理员ID", required = true)
    private String admin_id;
    @ApiModelProperty(value = "借阅时间", required = true)
    private LocalDate borrowDate;
    @ApiModelProperty(value = "归还时间")
    private LocalDate returnDate;



}
