package com.test04.Controller;

import com.test04.Entity.Student;
import com.test04.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

// @RestController
// 하나의 URL은 하나의 고유한 리소스를 대표하도록 설계된다 는 개념
// Rest 방식은 특정한 URL은 반드시 그에 상응하는 데이터 자체라는 것을 의미하는 방식이다.
// 컨트롤러 자체의 용도를 지정한다.

// annotation : 스프링 컨테이너에게 해당 클래스의 빈을 만들라고 알려줌

@RestController
@RequestMapping("/students")
public class StudentController {
    // @Autowired :
    // StudentService 빈을 찾아서 이 클래스에 주입해라 (dependency injection)
    // private StudentService studentService = new StudentService() 대신 사용
    // --> 결과적으로 클래스간 결합 줄이고, 유연성을 증가시킨다
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)         //@RequestMapping(value="/student", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){

        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){

        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

}
