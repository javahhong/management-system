package com.example.lambda.service;

import com.example.lambda.entity.Author;
import com.example.lambda.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能：获取到作家的集合。现在需要打印所有年龄小于18的作家的名字，并且要注意去重。
 */
public class DataInitializer {

    public static List<Author> getAuthor() {
        // 创建书籍列表
        List<Book> books1 = Arrays.asList(
                new Book(1L, "Book1", "Fiction", 8, "A great fiction book"),
                new Book(2L, "Book2", "Non-Fiction", 7, "An informative non-fiction book")
        );

        List<Book> books2 = Arrays.asList(
                new Book(3L, "Book3", "Science", 9, "A fascinating science book"),
                new Book(3L, "Book3", "Science", 9, "A fascinating science book"),
                new Book(4L, "Book5", "Biography", 8, "An inspiring biography")
        );

        List<Book> books3 = Arrays.asList(
                new Book(5L, "Book6", "Fantasy", 9, "An epic fantasy book"),
                new Book(6L, "Book7", "Mystery", 7, "A thrilling mystery book"),
                new Book(6L, "Book7", "Mystery", 7, "A thrilling mystery book")
        );

        // 创建作者列表
        Author author1 = new Author(1L, "Author1", 35, "Author1's bio", books1);
        Author author2 = new Author(2L, "Author2", 40, "Author2's bio", books2);
        Author author3 = new Author(3L, "Author3", 45, "Author3's bio", books3);
        Author author4 = new Author(4L, "Author4", 50, "Author4's bio", books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));

        return authorList;
    }
}