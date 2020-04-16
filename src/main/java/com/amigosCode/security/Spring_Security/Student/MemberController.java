package com.amigosCode.security.Spring_Security.Student;

import com.amigosCode.security.Spring_Security.Student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class MemberController {

    private static final List<Student> STUDENTS = new ArrayList<>(Arrays.asList(new Student(1, "james bond"),
            new Student(2, "jones")));


    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst().orElseThrow(() -> new IllegalStateException("Student " + studentId + "not found"));

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student member){
        System.out.println("registerNewStudent ");
        System.out.println(member);
    }
}
