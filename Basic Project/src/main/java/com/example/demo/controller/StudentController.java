package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String students(Model model){
        Student s = new Student("Kasun", "Colombo");
        model.addAttribute("student", s);
        return "student-view";
    }

    @GetMapping("/student")
    public String student(Model model){
        String dateStr = "2022-12-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;
        try {
            dob = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        Student s = new Student("Kasun", "Colombo", dob, 1L);
//        s = studentService.addStudent(s);
//        model.addAttribute("student", s);
        return "student-view";
    }

    @GetMapping("/add-student")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        model.addAttribute("success", true);
        return "add-student";
    }

    @RequestMapping(value = "/submit-student", method = RequestMethod.POST)
    public String submitStudentForm(@ModelAttribute StudentDto student) throws ParseException {
        // code to process the submitted Student object...
        Student stu = new Student(student.getName(),student.getName(),student.getDob());
        studentService.addStudent(stu);
        return "redirect:/add-student";
    }

    @GetMapping("/student-list")
    public String studentList(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "student-list-view";
    }
}
