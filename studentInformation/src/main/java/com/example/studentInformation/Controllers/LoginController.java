package com.example.studentInformation.Controllers;

import com.example.studentInformation.Entities.Student;
import com.example.studentInformation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value= "/verifyStudent")
    public String verifyStudent(@RequestParam(value="studentEmail") String studentEmail,
                                @RequestParam(value = "password") String password){

        if(studentEmail!=null && password!=null){
            return  loginService.isStudentPresent(studentEmail,password);
        }
        return "no,can't access further";
    }


}
