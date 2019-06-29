package com.test04.Service;

import com.test04.Dao.FakeStudentDaoImpl;
import com.test04.Dao.StudentDao;
import com.test04.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

// 비즈니스 로직 담당  (Controller와 Dao 사이)
// 여기선 복잡한 로직 안써
@Service
public class StudentService {

    @Autowired      // 실제 인스턴스의 값이 여기로 들어간다.
    private FakeStudentDaoImpl fakeStudentDaoImpl;
    @Qualifier("fakeData")  // studentDao를 상속받는 두 클래스 중 하나를 지정해줘야한다.
    private StudentDao studentDao;
    private String sample;

    public void setSample(String sample) {
        this.sample = sample;
    }



    public void setFakeStudentDaoImpl(FakeStudentDaoImpl fakeStudentDaoImpl)
    {
        this.studentDao = fakeStudentDaoImpl;
    }


    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);               // 해당 id의 학생을 students 맵에서 찾아서 가져오겠다.
    }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student){
        this.studentDao.insertStudentToDB(student);
    }
}
