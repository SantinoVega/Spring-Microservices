package com.service.student.repository;

import com.service.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select * from Student", nativeQuery = true)
    List<Student> findAllStudent();

    @Query(value = "Select * from Student where courseId = ?1", nativeQuery = true)
    List<Student> findStudentsByCourseId(Long courseId);

    List<Student> findAllByCourseId(Long courseId);
}
