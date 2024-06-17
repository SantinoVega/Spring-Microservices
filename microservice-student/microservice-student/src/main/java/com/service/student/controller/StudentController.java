package com.service.student.controller;

import com.service.student.entity.Student;
import com.service.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    IStudentService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        service.save(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id ) {
        Student student = service.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = service.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<List<Student>> findByIdCourse(@PathVariable Long idCourse) {
        List<Student> studetsList = service.findByIdCourse(idCourse);
        return ResponseEntity.ok(studetsList);
    }
}
