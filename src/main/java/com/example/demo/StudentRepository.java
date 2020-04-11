package com.example.demo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("SELECT id,sname,gender,class_id FROM student_info where sname=:name LIMIT 1")
    Student findByName(@Param("name") String name);
}
