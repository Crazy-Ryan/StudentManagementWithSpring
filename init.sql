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

INSERT INTO student_info(sname, gender, class_id)
VALUES ('张三', '男', '1-1'),
       ('李四', '男', '2-1'),
       ('王五', '女', '3-1');