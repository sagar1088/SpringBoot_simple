package com.jbk.springboot_simple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springboot_simple.entity.Student;


@RestController
public class StudentController {
	
	
	List<Student> list= new ArrayList<>();
	
	@PostMapping("/saveStudent")
	public List<Student> saveStudent(@RequestBody Student student)
	{
		list.add(student);
		
		return null;
		
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent()
	{
		return list;
		
	}
	
	@PutMapping("/updateStudent")
	public List<Student> updateStudent(@RequestBody Student student)
	{
		
		for(Student stud:list )
		{
			if(stud.getStudentId()==student.getStudentId())
			{
				list.remove(stud);
				list.add(student);
				break;
			}
			
		}
		return list;
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		String msg="data deleted";
		
		for(Student stud:list)
		{
			if(stud.getStudentId()==id)
			{
				list.remove(stud);
			}
		}
		return msg;
	}
	
	@GetMapping("/getById/{id}")
	public Student getById(@PathVariable int id)
	{
		Student st=null;
		for( Student stud:list) 
		{
			if(stud.getStudentId()==id)
			{
				st=stud;
				break;
			}
		}
		return st;
		
		
	}
	
	@GetMapping("/getByMarks/{marks}")
	public Student getByMarks(@PathVariable float marks)
	{
		Student student=null;
		
		for(Student stud:list)
		{
			if(stud.getStudentMarks()==marks)
			{
				student=stud;
			}
		}
		return student;
		
	}
	
}
