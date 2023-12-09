package com.example.demo6.Controller;


import com.example.demo6.Model.Student;
import com.example.demo6.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class StudentController {
    @Autowired
     StudentService studentService;
    @RequestMapping("/add-Marks")
    public String insertStudentMarks(Model model)
    {

        model.addAttribute("student",new Student());
        return "insert-student-marks";
    }

    @RequestMapping(value="/submit-Marks", method= RequestMethod.POST)
    public String submitStudentMarks (@ModelAttribute Student student, Model model)
    {
        student.setFinalMarks((student.getCaMarks()*0.2)+(student.getPracticalMarks()*0.2)+(student.getTheoryMarks()*0.6));
        studentService.insertStudent(student);
        System.out.println(student.toString());
        return "redirect:/add-Marks";
    }
    @RequestMapping ("/view-Marks")
    public String viewStudentMarks(Model model)
    {

        model.addAttribute("students",studentService.getStudentsMark());
        return "view-student-marks";
    }



}
