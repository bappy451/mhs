package com.example.studentdemo.Converter;


import com.example.studentdemo.Command.StudentCommad;
import com.example.studentdemo.Models.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandToStudent implements Converter<StudentCommad, Student>{

    @Synchronized
    @Nullable
    @Override
    public Student convert(StudentCommad source) {
        if (source == null) {
            return null;
        }

        final Student student = new Student();
        student.setImage(source.getImage());
        student.setId(source.getId());
        student.setBatch(source.getBatch());
        student.setStudentName(source.getStudentName());
        return student;
    }
}
