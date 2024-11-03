package com.example.LibraryManagementSystem.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Loan {
    private Book book;
    private User user;
}
