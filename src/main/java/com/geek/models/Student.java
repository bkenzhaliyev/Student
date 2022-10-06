package com.geek.models;

import lombok.Data;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Student.findByName",
                query = "SELECT s FROM Student s Where s.name=:name")
})

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Column(name ="name", nullable = false, length = 35, unique = true)
    private String name;

    @Column(name ="age", nullable = false, length = 2)
    private Integer age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
