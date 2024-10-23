package com.example.LibraryManagementSystem.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private String title;
    private String author;
    private Integer isbn;
    private Integer avaliableCopies;
}