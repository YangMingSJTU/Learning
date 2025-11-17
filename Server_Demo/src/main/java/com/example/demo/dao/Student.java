package com.example.demo.dao;

import jakarta.persistence.*;

// 标记一个 Java 类为 “实体类”，表示该类对应数据库中的一张表，类中的属性将映射为表中的字段。
@Entity
// 用于指定实体类对应的数据库表的详细信息（如表名、所属 schema、索引等）
// 通常与 @Entity 配合使用，补充表的元数据配置。
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    // name 赋值和变量名相同时，可以不写上述的注解
    // @Column(name = "email")
    private String email;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
