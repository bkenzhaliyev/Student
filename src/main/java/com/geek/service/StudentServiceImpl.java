package com.geek.service;

import com.geek.dao.StudentDaoImpl;
import com.geek.models.Student;
import com.geek.models.StudentDTO;
import com.geek.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDaoImpl studentsDao = new StudentDaoImpl();

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findStudent(long id) {
        return studentsDao.findById(id);
    }

    @Override
    public void saveProduct(Student student) {
        studentsDao.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentsDao.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentsDao.update(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentsDao.findAll();
    }

    @Override
    public void deleteStudentById(long id) {

    }
}
