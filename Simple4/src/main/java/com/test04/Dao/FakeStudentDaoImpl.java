package com.test04.Dao;

import com.test04.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


// data와 관련된 클래스(빈)에는  @Repository 애노테이션을 붙인다.

@Repository     // Spring Bean
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;      // integer : 학번, Student :학생 객체

    // db와 연동하여 객체를 이용해 어플리케이션에 전달
    // 데이터를 직접적으로 다루고, 이를 객체를 통해 전달한다.


    // 1. 데이터 저장 (객체에)
    // 이때 db를 조회하여 객체로 저장할 수 있다.
    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1,"홍길동","컴공"));
                put(2, new Student(2,"임꺽정","생명"));
                put(3, new Student(3,"장길산","전자"));
            }
        };
    }

    // 타 클래스에 객체 전달
    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }


    // id를 바탕으로 객체를 반환하는 메서드
    @Override
    public Student getStudentById(int id){
        return this.students.get(id);               // 해당 id의 학생을 students 맵에서 찾아서 가져오겠다.
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);           //. remove : hashMap에 있는 메서드
    }

    @Override
    public void updateStudent(Student student){
        // 업데이트할 대상인 student 객체를 students에서 꺼냄 (by id)
        Student s = students.get(student.getId());

        // 해당 student 객체의 course, name을 변경
        s.setCourse(student.getCourse());
        s.setName(student.getName());

        // students 맵<Integer, Student> 에 update할 student객체의 번호와 객체를 저장
        students.put(student.getId(), s);

    }

    @Override
    public void insertStudentToDB(Student student) {
        this.students.put(student.getId(), student);
    }
}
