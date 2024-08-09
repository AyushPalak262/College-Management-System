package com.student.StudentData.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.StudentData.entity.Student;
import com.student.StudentData.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	
	@GetMapping
	public String home() {
		return "home";
	}
	@GetMapping("/form")
	public String getStudentForm() {
		return "studentform";
	}
	@PostMapping("/submit-student-details")
	public String PostStudentForm(@ModelAttribute Student student) {
		System.out.println("Student Details  : "+student);
		
		this.studentService.add(student);

		return "success";
	}
	
	@GetMapping("/display")
	public String showAllStudents(Model model){
		System.out.println(studentService.allStudents());
		model.addAttribute("students",studentService.allStudents());
		return "display";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.findbyStudentId(id));
		return "edit";
	}

	
	@PostMapping("/students/{id}")
	  public String updateStudent(@PathVariable Long
	  id,@ModelAttribute("student") Student student, Model model) {
	  
	  
	  // get student from database by id 
		  
	  Student existingStudent=studentService.findbyStudentId(id); 
	  existingStudent.setFirst_name(student.getFirst_name());
	  existingStudent.setLast_name(student.getLast_name());
	  existingStudent.setClass_number(student.getClass_number());
	  existingStudent.setSection(student.getSection());
	  existingStudent.setEmail(student.getEmail());
	  existingStudent.setHeight(student.getHeight());
	  existingStudent.setWeight(student.getWeight());
	  existingStudent.setAddress(student.getAddress());
	  
	  // save updated student object studentService.updateStudent(existingStudent);
	  
	  studentService.updateStudent(existingStudent);
	  return "redirect:/display";
	  }
	
	// handler method to handle delete student request
	
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			studentService.deleteStudentById(id);
			return "redirect:/display";
		}
		
		
		//search student by ID
		@PostMapping("/view-student-details")
		public String SearchStudent(@ModelAttribute("student") Student student,Model model)
		{
			System.out.println(student.getId());
			
			model.addAttribute("students", studentService.findbyStudentId(student.getId()));
			return "view";
			
		}
	
}
