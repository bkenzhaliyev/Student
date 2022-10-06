package com.geek.service;

import com.geek.models.Student;
import com.geek.models.StudentDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface StudentService {
    public Student findStudent(long id);
//    public void saveStudent(Student student);
    public void deleteStudent(Student student);
    public void deleteStudentById(long id);
    public void updateStudent(Student student);
    public List<Student> findAllStudent();

    @RequestMapping("/saveStudent")
    void saveProduct(@RequestBody Student student);

}
