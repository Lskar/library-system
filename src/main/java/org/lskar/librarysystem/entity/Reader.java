package org.lskar.librarysystem.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.GenderEnum;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "读者实体")
public class Reader {

    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "性别", required = true)
    private GenderEnum gender;
    @ApiModelProperty(value = "注册时间", required = true)
    private LocalDate enrollDate;
    @ApiModelProperty(value = "用户类型", required = true)
    private String userType;
    @ApiModelProperty(value = "借阅限制", required = true)
    private Integer borrowLimit;
}
