package org.lskar.librarysystem.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.StatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "图书分页查询参数")
public class BookQueryParam {

    @ApiModelProperty(value = "页码", required = true)
    private Integer page;
    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;
    @ApiModelProperty(value = "图书名称")
    private String title;
    @ApiModelProperty(value = "图书作者")
    private String author;
    @ApiModelProperty(value = "图书类别")
    private String category;
    @ApiModelProperty(value = "图书状态")
    private StatusEnum statusEnum;


    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String begin;
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end;

}
