package com.example.studentdemo.Service;

import com.example.studentdemo.Command.StudentCommad;
import com.example.studentdemo.Converter.StudentCommandToStudent;
import com.example.studentdemo.Converter.StudentToStudentCommand;
import com.example.studentdemo.Models.Student;
import com.example.studentdemo.Repositorys.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class StudnetServiceImp implements StudentService {

    private final StudentToStudentCommand studentToStudentCommand;
    private final StudentCommandToStudent studentCommandToStudent;
    private final StudentRepository studentRepository;

    public StudnetServiceImp(StudentToStudentCommand studentToStudentCommand, StudentCommandToStudent studentCommandToStudent, StudentRepository studentRepository) {
        this.studentToStudentCommand = studentToStudentCommand;
        this.studentCommandToStudent = studentCommandToStudent;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentCommad saveStudentCommand(StudentCommad commad) {
        Student detachdStudent = studentCommandToStudent.convert(commad);

        Student savedStudent = studentRepository.save(detachdStudent);
        System.out.println("saved student");
        return studentToStudentCommand.convert(savedStudent);
    }

    @Override
    public Student findById(Long l) {
        Optional<Student> studentOptional = studentRepository.findById(l);

        if(!studentOptional.isPresent()){
            throw new RuntimeException("Studnet not found");
        }
        return studentOptional.get();
    }

    @Override
    public StudentCommad findCommandByID(Long l) {
        return studentToStudentCommand.convert(findById(l));
    }

    @Override
    public void saveImageFile(Long id, MultipartFile file) {

        try {
            Student student = studentRepository.findById(id).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            student.setImage(byteObjects);

            studentRepository.save(student);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }

    }
}
