package com.student.StudentData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentData.entity.Student;
import com.student.StudentData.repository.StudentRepository;
import com.student.StudentData.service.StudentService;

@Service
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public StudentImpl(StudentRepository studentRepo)
	{
		this.studentRepo=studentRepo;
	}

	@Override
	public List<Student> allStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student add(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student findbyStudentId(Long id) {
		
		return studentRepo.getById(id);
	}

	@Override
	public Student updateStudent(Student existingStudent) {
		
		return studentRepo.save(existingStudent);
	}

	@Override
	public void deleteStudentById(Long id) {
		Student student=studentRepo.getById(id);
		studentRepo.delete(student);
		
	}

}
