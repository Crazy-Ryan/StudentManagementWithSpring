package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    private StudentRepo studentRepo =  new StudentRepo(Arrays.asList(
            new Student("张三","男","1-1"),
            new Student("李四","男","2-1"),
            new Student("王五","女","3-1")
    ));
    @GetMapping("/all")
    public String getAllStudent(){
        return studentRepo.toString();
    }
}
