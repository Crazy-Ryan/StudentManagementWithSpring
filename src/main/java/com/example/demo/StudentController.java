package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return "添加成功";
        } else {
            return "姓名重复";
        }
    }

    @PostMapping("/find")
    public String findStudentByName(@RequestBody String name) {
        Student studentFound = studentService.findStudentByName(name);
        if (null != studentFound) {
            return studentFound.toString();
        } else {
            return "没有找到名为" + name + "的学生";
        }
    }

    @GetMapping("/all")
    public String getAllStudent() {
        List<Student> allStudents = studentService.getAllStudent();
        StringBuilder result = new StringBuilder();
        for (Student student : allStudents) {
            result.append(student.toString()).append("\n");
        }
        return result.toString();
    }

    @PostMapping("/remove")
    public String removeStudentByName(@RequestBody String name) {
        if (studentService.removeStudentByName(name)) {
            return "删除成功";
        } else {
            return "该学生不存在";
        }
    }
}
