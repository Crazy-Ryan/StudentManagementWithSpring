CREATE DATABASE tw_spring_student DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
USE tw_spring_student;
CREATE TABLE student_info
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    sname    VARCHAR(50),
    gender   VARCHAR(10),
    class_id VARCHAR(10)
) CHARSET utf8mb4,
  ENGINE = InnoDB;