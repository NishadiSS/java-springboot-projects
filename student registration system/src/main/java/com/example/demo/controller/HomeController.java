package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home.html");
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = true, defaultValue = "world") String name,
                           Model model){
        model.addAttribute("name", name);
        return "greeting";
    }

}
