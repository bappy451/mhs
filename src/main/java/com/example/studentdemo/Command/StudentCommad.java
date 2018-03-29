package com.example.studentdemo.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentCommad {
    private Long id;
    private String StudentName;
    private String Batch;
    private Byte[] image;

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }
}
