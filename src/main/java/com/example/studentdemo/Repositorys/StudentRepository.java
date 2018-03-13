package com.example.studentdemo.Repositorys;

import com.example.studentdemo.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
