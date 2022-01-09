package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.model.StudentGroup;
import com.example.demo.service.StudentGroupServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/groups")
@RestController

public class StudentGroupController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private StudentGroupServiceImpl studentGroupServiceImpl;


    public StudentGroupController(StudentServiceImpl studentServiceImpl, StudentGroupServiceImpl studentGroupServiceImpl) {
     this.studentServiceImpl = studentServiceImpl;
     this.studentGroupServiceImpl = studentGroupServiceImpl;
    }

    @GetMapping(value = "/get/studentGroup")
    public ResponseEntity<List<StudentGroup>> read() {
        final List<StudentGroup> studentGroups = studentGroupServiceImpl.getAll();
        return new ResponseEntity<>(studentGroups, HttpStatus.OK);
    }

    @GetMapping(value = "/get/studentGroup/{id}/students")
    public ResponseEntity<List<Student>> readStudent(@PathVariable(name = "id") int groupID) {
        if (studentGroupServiceImpl.get(groupID) != null) {
            List<Student> students = studentServiceImpl.getAllStudentsByGroup(groupID);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/get/studentGroup/{id}")
    public ResponseEntity<StudentGroup> read(@PathVariable(name = "id") int id) {
        final StudentGroup studentGroup = studentGroupServiceImpl.get(id);

        return studentGroup != null
                ? new ResponseEntity<>(studentGroup, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/post/studentGroups")
    public ResponseEntity<?> create(@Valid @RequestBody StudentGroup studentGroup) {
        studentGroupServiceImpl.save(studentGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/put/studentGroup/{id}")
    public ResponseEntity<?> update(@RequestBody StudentGroup studentGroup, long id) {
        final boolean updated = studentGroupServiceImpl.update(studentGroup, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/studentGroup/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = studentGroupServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
