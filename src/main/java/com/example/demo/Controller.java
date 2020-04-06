package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    private StudentRepo studentRepo = new StudentRepo(new ArrayList<Student>() {{
        add(new Student("张三", "男", "1-1"));
        add(new Student("李四", "男", "2-1"));
        add(new Student("王五", "女", "3-1"));
    }});

    @PostMapping("add")
    public String addStudent(@RequestBody Student student) {

        if (studentRepo.addStudent(student)) {
            return "添加成功";
        } else {
            return "姓名重复";
        }
    }

    @GetMapping("/all")
    public String getAllStudent() {
        return studentRepo.toString();
    }

    @PostMapping("/find")
    public String findStudentByName(@RequestBody String name) {
        Student studentFound = studentRepo.findStudentByName(name);
        if (null != studentFound.getName()) {
            return studentFound.toString();
        } else {
            return "没有找到名为" + name + "的学生";
        }
    }


}
