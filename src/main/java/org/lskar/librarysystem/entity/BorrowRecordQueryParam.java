package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 1, message = "页码不允许小于1")
    @NotNull(message = "页码不允许为空")
    private Integer page;

    @ApiModelProperty(value = "每页数量", required = true)
    @Min(value = 1, message = "每页数量不允许小于1")
    @NotNull(message = "每页数量不允许为空")
    private Integer pageSize;

    @ApiModelProperty(value = "用户ID",  required = true)
    @NotBlank(message = "用户ID不允许为空")
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
