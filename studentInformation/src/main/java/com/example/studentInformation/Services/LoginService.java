package com.example.studentInformation.Services;

import com.example.studentInformation.Entities.Student;
import com.example.studentInformation.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private StudentRepository studentRepository;

    public String isStudentPresent(String studentEmail,String password){
        if(studentRepository.findByStudentEmail(studentEmail)==null)
        {

            System.out.println(studentRepository.findByStudentEmail(studentEmail)+"till here");
            return "no";
        }
        Student student = studentRepository.findByStudentEmail(studentEmail);
        String pass=student.getPassword();
        System.out.println(pass+"here");
        System.out.println(password+"here");
        if(pass.equals(password))
            return "yes, you are logged in";
        else {
            System.out.println("here");
            return "no,can't access further";
        }
    }
}
