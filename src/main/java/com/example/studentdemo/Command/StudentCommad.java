package com.example.studentdemo.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentCommad {
    private Long id;
    private String StudentName;
    private String Batch;
    private Byte[] image;

    public Byte[] getImage() {
        return image;
    }
}
