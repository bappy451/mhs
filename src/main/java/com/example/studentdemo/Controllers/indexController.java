package com.example.studentdemo.Controllers;

import com.example.studentdemo.Repositorys.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    private StudentRepository studentRepository;

    @Autowired
    public indexController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping({"","/","/mhs"})
    public String getStudent(Model model){
        model.addAttribute("s",studentRepository.findAll());

        return "index";
    }
}
