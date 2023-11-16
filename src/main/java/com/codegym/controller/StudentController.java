package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class StudentController {
    @Autowired
    private IStudentService  studentService;

    @GetMapping("/home")
    public String index(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("student", students);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "/create";
    }
    @PostMapping("/create")
    public String save(Student student) {
        System.out.println(student.getName());
        studentService.save(student);
        return "redirect:/home";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("image",student.getImage());
        model.addAttribute("student",student);
        return "/update";
    }
    @PostMapping("/update")
    public String update(Student student) {
        studentService.save(student);
        return "redirect:/home";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("studentID") Long studentID) {
        studentService.remove(studentID);
        return "redirect:/home";
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String q){
        List<Student> students = studentService.search(q);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("student",students);
        return modelAndView;
    }

}
