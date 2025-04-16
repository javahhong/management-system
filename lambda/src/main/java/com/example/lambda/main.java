package com.example.lambda;

import com.example.lambda.entity.Author;

import java.util.List;

import static com.example.lambda.service.DataInitializer.getAuthor;

/**
 * @program: untitled
 * @author: hhong
 * @create: 2025-04-14 12:54
 **/
public class main {
    public static void main(String[] args) {
        List<Author> authors = getAuthor();

    }
}
