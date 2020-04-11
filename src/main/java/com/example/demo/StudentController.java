package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/user/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }


    @PostMapping("/find")
    public String findStudentByName(@RequestBody String name) {
        Student studentFound = studentRepository.findByName(name);
        if (null != studentFound) {
            return studentFound.toString();
        } else {
            return "没有找到名为" + name + "的学生";
        }
    }

//    @PostMapping("add")
//    public String addStudent(Student newStudent) {
//
//    }
}
