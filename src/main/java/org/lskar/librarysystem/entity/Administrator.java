package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "管理员实体")
public class Administrator {

    private String adminId;
    private String name;
    private String password;
    private Gender gender;

}
