package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

  @Autowired
  private StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping(value = "/get/students")
    @ResponseBody
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentServiceImpl.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/get/new")
    public ModelAndView createStudent() {
        Student student = new Student();
        return new ModelAndView("student/studentEdit").addObject("student", student);
    }

    @GetMapping("/get/{id}")
    public ModelAndView viewStudent(@PathVariable("id") long id) {
        Student student = studentServiceImpl.get(id);
        if (student == null) {
            throw new ResourceNotFoundException();
        }
        ModelAndView model = new ModelAndView("student/studentView");
        model.addObject("student", student);
        return model;
    }

    @GetMapping("/get/{id}/edit")
    public ModelAndView editStudent(@PathVariable("id") int id) {
        Student student = studentServiceImpl.get(id);

        return new ModelAndView("student/studentEdit").addObject("student", student);
    }

    @PostMapping(value = "/post/delete")
    public ModelAndView delete(Student studentID) {
        Student student = studentServiceImpl.get(studentID.getId());
        if (student == null) {
            throw new ResourceNotFoundException();
        } else {
            studentServiceImpl.delete(studentID.getId());
        }
        return new ModelAndView("redirect:/students/");
    }
    @PostMapping("/post/save")
    public String saveStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/students/";
        }
        if (student.getId() != null) {
            studentServiceImpl.update(student);
        } else {
            studentServiceImpl.save(student);
        }
        return "redirect:/students/" + student.getId();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }

}
