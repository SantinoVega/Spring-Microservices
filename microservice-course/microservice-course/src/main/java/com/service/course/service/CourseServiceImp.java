package com.service.course.service;

import com.service.course.client.StudentClient;
import com.service.course.dto.StudentDto;
import com.service.course.entity.CourseEntity;
import com.service.course.http.response.StudentByCourseResponse;
import com.service.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements  ICourseService{

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    StudentClient studentClient;
    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(CourseEntity course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findAllStudentsByIdCourse(Long id) {
        // Consultar el curso
        CourseEntity curso = courseRepository.findById(id).orElse(new CourseEntity());

        // Obtener los estudiantes
        List<StudentDto> studentDtoList = studentClient.findAllStudentByIdCourse(id);

        return StudentByCourseResponse.builder()
                .courseName(curso.getName())
                .teacher(curso.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }
}
