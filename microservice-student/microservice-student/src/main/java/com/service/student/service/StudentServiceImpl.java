package com.service.student.service;

import com.service.student.entity.Student;
import com.service.student.repository.StudentRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> studentsList = studentRepository.findAll();
        return studentsList;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long courseId) {
        List<Student> studentsList = studentRepository.findAllByCourseId(courseId);
        return studentsList;
    }
}
