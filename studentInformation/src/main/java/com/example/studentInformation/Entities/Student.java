package com.example.studentInformation.Entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    @Column
    @Size(max=30)
    @NotNull
    private String studentName;


    @Column(unique = true)
    @Size(max=30)
    @NotNull
    @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)")
    private String studentEmail;

    @Column
    @Size(max=10)
    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})")
    private String studentPhoneNo;

    @Column
    @Size(max=20)
    @NotNull
    private String password;


    public Student(long studentId, @Size(max = 30) @NotNull String studentName, @Size(max = 100) @NotNull @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)") String studentEmail, @Size(max = 50) @NotNull @Pattern(regexp = "(^$|[0-9]{10})") String studentPhoneNo, @Size(max = 20) @NotNull String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhoneNo = studentPhoneNo;
        this.password = password;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public void setStudentPhoneNo(String studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
