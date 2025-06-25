package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.GenderEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "管理员实体")
public class Administrator {

    @ApiModelProperty(value = "管理员ID", required = true)
    @NotBlank(message = "管理员id不允许为空")
    private String adminId;

    @ApiModelProperty(value = "管理员名称", required = true)
    private String name;

    @ApiModelProperty(value = "管理员密码", required = true)
    private String password;

    @ApiModelProperty(value = "管理员性别", required = true)
    private GenderEnum gender;

}
