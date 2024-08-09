package com.student.StudentData.service;

import java.util.List;

import com.student.StudentData.entity.Student;

public interface StudentService {
	
	List<Student> allStudents();
	Student add(Student student);
	Student findbyStudentId(Long id);
	Student updateStudent(Student existingStudent);
	void deleteStudentById(Long id);

}
