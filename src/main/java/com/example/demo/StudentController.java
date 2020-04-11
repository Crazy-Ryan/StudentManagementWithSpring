package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        if (null == studentRepository.findByName(student.getName())) {
            studentRepository.save(student);
            return "添加成功";
        } else {
            return "姓名重复";
        }
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

    @GetMapping("/all")
    public String getAllStudent() {
        Iterable<Student> allStudentIter = studentRepository.findAll();
        StringBuilder result = new StringBuilder();
        allStudentIter.forEach(student -> result.append(student.toString()).append("\n"));
        return result.toString();
    }

    @PostMapping("/remove")
    public String removeStudentByName(@RequestBody String name) {
        Student studentFound = studentRepository.findByName(name);
        if (null != studentFound) {
            studentRepository.delete(studentFound);
            return "删除成功";
        } else {
            return "该学生不存在";
        }
    }
}
