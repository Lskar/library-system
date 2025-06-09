package org.lskar.librarysystem.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "借阅记录")
public class BorrowRecord {

    private Integer recordId;
    private String userId;
    private String bookId;
    private String admin_id;
    private LocalDate borrowDate;
    private LocalDate returnDate;



}
