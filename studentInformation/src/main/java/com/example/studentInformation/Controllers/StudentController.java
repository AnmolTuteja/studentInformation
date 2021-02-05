package com.example.studentInformation.Controllers;


import com.example.studentInformation.Entities.Student;
import com.example.studentInformation.Services.StudentService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value="/getStudent/{studentId}")
    public Student getStudentByStudentId(@PathVariable("studentId") Long studentId) throws BadHttpRequest {

        if(studentId==0)
            throw new BadHttpRequest();

        return studentService.getStudentByStudentId(studentId);
    }

    @PostMapping(value = "/postStudent")
    public String postStudent(@RequestParam(value="studentName", required = false) String studentName,
                            @RequestParam(value="studentPhoneNo", required = false) String studentPhoneNo,
                            @RequestParam(value="studentEmail") String studentEmail,
                            @RequestParam(value="password") String password){
        Student student=new Student();
        student.setStudentName(studentName);
        student.setStudentEmail(studentEmail);
        student.setStudentPhoneNo(studentPhoneNo);
        student.setPassword(password);
        studentService.postStudent(student);
        return "you have successfully signed up!";
    }
}
