package com.example.studentdemo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private Long id;
    private String StudentName;
    private String Batch;
    @Lob
    private Byte[] image;

}
