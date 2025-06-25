package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.StatusEnum;
import org.w3c.dom.Text;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "图书实体")
public class Book {
    @ApiModelProperty(value = "图书ID", required = true)
    @NotBlank(message = "图书id不允许为空")
    private String bookId;

    @ApiModelProperty(value = "图书标题", required = true)
    private String title;

    @ApiModelProperty(value = "图书作者", required = true)
    private String author;

    @ApiModelProperty(value = "图书出版社", required = true)
    private String publisher;

    @ApiModelProperty(value = "图书类别", required = true)
    private String category;

    @ApiModelProperty(value = "图书出版时间", required = true)
    private LocalDate publishDate;

    @ApiModelProperty(value = "图书价格", required = true)
    private double price;

    @ApiModelProperty(value = "图书简介")
    private String summary;

    @ApiModelProperty(value = "图书管理员ID", required = true)
    private String adminId;

    @ApiModelProperty(value = "图书状态", required = true)
    private StatusEnum status;

}
