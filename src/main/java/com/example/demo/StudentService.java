package com.example.demo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean addStudent(Student student) {
        if (null == studentRepository.findByName(student.getName())) {
            studentRepository.save(student);
            return true;
        } else {
            return false;
        }
    }

    public Student findStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getAllStudent() {
        Iterable<Student> allStudentIter = studentRepository.findAll();
        List<Student> allStudents = new ArrayList<>();
        allStudentIter.forEach(allStudents::add);
        return allStudents;
    }

    public boolean removeStudentByName(String name) {
        Student studentFound = studentRepository.findByName(name);
        if (null != studentFound) {
            studentRepository.delete(studentFound);
            return true;
        } else {
            return false;
        }
    }
}
