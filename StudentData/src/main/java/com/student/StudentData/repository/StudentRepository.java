package com.student.StudentData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.StudentData.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student getById(Long id);
}
