package com.example.LibraryManagementSystem.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private int id;
    private String title;
    private String author;
    private int isAvailable;
    private Integer user_id;
}