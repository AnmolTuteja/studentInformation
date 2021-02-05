package com.example.studentInformation.Services;

import com.example.studentInformation.Entities.Student;
import com.example.studentInformation.Repositories.StudentRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByStudentId(Long studentId) throws BadHttpRequest {

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else
            throw new BadHttpRequest();
    }

    public void postStudent(Student student){
        studentRepository.save(student);
    }
}
