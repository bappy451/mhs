package com.example.studentdemo.Controllers;

import com.example.studentdemo.Command.StudentCommad;
import com.example.studentdemo.Models.Student;
import com.example.studentdemo.Repositorys.StudentRepository;
import com.example.studentdemo.Service.StudentService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Controller
public class NewStudentController {
    private StudentRepository studentRepository;
    private StudentService studentService;
    private StudentCommad studentCommad;

    @Autowired
    public NewStudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }
    @RequestMapping({"/new","/studnet"})
    public String getStudent(Model model){
        System.out.println("i'm in the method");
        model.addAttribute("student",new StudentCommad());
        return "Student/newStudent";
    }

    @PostMapping("/Student")
    public String saveOrUpdate(@ModelAttribute StudentCommad commad){
        System.out.println("I'm here now");
        System.out.println(commad.getStudentName());
        StudentCommad savedCommand = studentService.saveStudentCommand(commad);
        return "redirect:index";
    }

    @PostMapping("Student/update")
    public String updateStudent(@ModelAttribute StudentCommad commad, Model model, HttpServletResponse response,@RequestParam("imagefile") MultipartFile file) throws IOException {
        System.out.println("hi im there");
        studentService.saveImageFile(commad.getId(),file);

        StudentCommad studentCommad = studentService.findCommandByID(commad.getId());
        studentCommad.setStudentName(commad.getStudentName());
        studentCommad.setBatch(commad.getBatch());

        System.out.println(commad.getStudentName()+ Arrays.toString(studentCommad.getImage()));

        StudentCommad studentCommad1 = studentService.saveStudentCommand(studentCommad);
        model.addAttribute("s",studentCommad1);
        return "Student/update";
    }

    @GetMapping("Student/{id}/image")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        StudentCommad recipeCommand = studentService.findCommandByID(Long.valueOf(id));

        if (recipeCommand.getImage() != null) {
            byte[] byteArray = new byte[recipeCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
