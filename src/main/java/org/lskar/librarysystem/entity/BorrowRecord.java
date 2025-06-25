package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "用户ID不允许为空")
    private String userId;

    @ApiModelProperty(value = "图书ID", required = true)
    @NotBlank(message = "图书ID不允许为空")
    private String bookId;

    @ApiModelProperty(value = "管理员ID")
    private String adminId;

    @ApiModelProperty(value = "借阅时间", required = true)
    private LocalDate borrowDate;

    @ApiModelProperty(value = "归还时间")
    private LocalDate returnDate;
}
