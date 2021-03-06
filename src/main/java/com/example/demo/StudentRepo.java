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

    public Student findStudentByName(String name) {
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return new Student();
    }

    public boolean removeStudentByName(String name) {
        Student studentToDelete = null;
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                studentToDelete = student;
            }
        }
        if (null != studentToDelete) {
            studentList.remove(studentToDelete);
            return true;
        } else {
            return false;
        }
    }
}
