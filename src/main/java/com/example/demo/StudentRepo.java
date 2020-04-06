package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepo {
    private List<Student> studentList;

    public StudentRepo() {
        studentList = new ArrayList<>();
    }

    public StudentRepo(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Student student : studentList) {
            result.append(student.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public boolean addStudent(Student newStudent) {
        for (Student student : studentList) {
            if (student.getName().equals(newStudent.getName())) {
                return false;
            }
        }
        studentList.add(newStudent);
        return true;
    }
}
