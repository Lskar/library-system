package org.lskar.librarysystem.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lskar.librarysystem.enums.Status;
import org.w3c.dom.Text;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "图书实体")
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private LocalDate publishDate;
    private double price;
    private Text summary;
    private String admin_id;
    private Status status;

}
