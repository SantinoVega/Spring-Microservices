package com.service.course.service;

import com.service.course.entity.CourseEntity;
import com.service.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    CourseEntity findById(Long id);
    List<CourseEntity> findAll();
    void save(CourseEntity course);

    StudentByCourseResponse findAllStudentsByIdCourse(Long id);
}
