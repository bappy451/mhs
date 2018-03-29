package com.example.studentdemo.Converter;

import com.example.studentdemo.Command.StudentCommad;
import com.example.studentdemo.Models.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentCommand implements Converter<Student, StudentCommad> {

    @Synchronized
    @Nullable
    @Override
    public StudentCommad convert(Student source) {
        if (source == null) {
            return null;
        }

        final StudentCommad commad = new StudentCommad();
        commad.setId(source.getId());
        commad.setImage(source.getImage());
        commad.setStudentName(source.getStudentName());
        commad.setBatch(source.getBatch());

        return commad;
    }
}
