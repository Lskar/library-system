package org.lskar.librarysystem.entity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "读者实体")
public class Reader {

    private String userId;
    private String userName;
    private String password;
    private Gender gender;
    private LocalDate enrollDate;
    private String userType;
    private Integer borrowLimit;
    List<BorrowRecord> borrowRecords;
}
