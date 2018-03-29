package com.example.studentdemo.Controllers;

import com.example.studentdemo.Repositorys.StudentRepository;
import com.example.studentdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImageController {
    private StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    public ImageController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }


}
