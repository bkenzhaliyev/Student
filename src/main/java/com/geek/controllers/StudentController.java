package com.geek.controllers;

import com.geek.models.Student;
import com.geek.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentService;

    @GetMapping("")
    public String getAll(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);
        System.out.println("request student page...");
        return "student-page";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "add-student-form";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        System.out.println("Delete by id = " + id);
        studentService.deleteById(id);
        return "redirect:/student";
    }


    @PostMapping("/add")
    public String newStudent(@ModelAttribute("newStudent") Student newStudent) {
        System.out.println("Insert new student: " + newStudent.getName());
        if (newStudent != null) {
            studentService.save(newStudent);
        }
        return "redirect:/student";
    }

}
