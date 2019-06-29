package com.test04.Dao;

import com.test04.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    // 타 클래스에 객체 전달
    Collection<Student> getAllStudents();

    // id를 바탕으로 객체를 반환하는 메서드
    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDB(Student student);
}
