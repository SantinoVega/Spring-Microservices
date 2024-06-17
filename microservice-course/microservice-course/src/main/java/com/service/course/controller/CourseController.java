package com.service.course.controller;

import com.service.course.entity.CourseEntity;
import com.service.course.http.response.StudentByCourseResponse;
import com.service.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    ICourseService service;

    @GetMapping("/search/{id}")
    public ResponseEntity<CourseEntity> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody CourseEntity course){
        service.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseEntity>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<StudentByCourseResponse> studentsByCourse(@PathVariable Long idCourse){
        StudentByCourseResponse response = service.findAllStudentsByIdCourse(idCourse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
