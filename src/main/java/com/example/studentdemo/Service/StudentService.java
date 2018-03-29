package com.example.studentdemo.Service;

import com.example.studentdemo.Command.StudentCommad;
import com.example.studentdemo.Models.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    StudentCommad saveStudentCommand(StudentCommad commad);
    Student findById(Long l);
    StudentCommad findCommandByID(Long l);
    void saveImageFile(Long id, MultipartFile file);
}
