package com.githungo.thymeleaf.controller;

import com.githungo.thymeleaf.model.Instructor;
import com.githungo.thymeleaf.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/instructors/")
public class instructorController {
    private final InstructorRepository instructorRepository;

    @Autowired
    public instructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Instructor instructor) {
        return "add-instructor";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("instructors", instructorRepository.findAll());
        return "index-instructor";
    }

    @PostMapping("add")
    public String addInstructor(@Valid Instructor instructor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-instructor";
        }
        instructorRepository.save(instructor);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid instructor Id:" + id));
        model.addAttribute("instructor", instructor);
        return "update-instructor";
    }

    @PostMapping("update/{id}")
    public String updateInstructor(@PathVariable("id") long id, @Valid Instructor instructor, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            instructor.setId(id);
            return "update-instructor";
        }

        instructorRepository.save(instructor);
        model.addAttribute("instructors", instructorRepository.findAll());
        return "index-instructor";
    }

    @GetMapping("delete/{id}")
    public String deleteInstructor(@PathVariable("id") long id, Model model) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid instructor Id:" + id));
        instructorRepository.delete(instructor);
        model.addAttribute("instructors", instructorRepository.findAll());
        return "index-instructor";
    }


}
