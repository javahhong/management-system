package com.example.lambda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor    //有参构造
@NoArgsConstructor     //无参构造
@EqualsAndHashCode     //去重
public class Author {
    private Long id;
    private String name;
    private Integer age;
    private String bio;     // 简介
    private List<Book> books;   // 新增图书列表字段
}