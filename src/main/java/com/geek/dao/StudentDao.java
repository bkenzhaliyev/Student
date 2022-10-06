package com.geek.dao;

import com.geek.models.Student;

import java.util.List;

public interface StudentDao {
    public Student findById(long id);
    public void save(Student student);
    public void update(Student student);
    public void delete(Student student);
    public List<Student> findAll();
}
