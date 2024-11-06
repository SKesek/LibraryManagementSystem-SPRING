package com.example.LibraryManagementSystem.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoanedBook {
    private int bookId;
    private String bookTitle;
    private String userName;
    private Integer userCardNumber;
}
