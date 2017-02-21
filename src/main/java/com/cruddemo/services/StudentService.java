package com.cruddemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruddemo.businessservice.StudentBusinessServiceImpl;
import com.cruddemo.model.Student;

@RestController
@RequestMapping("/student")
public class StudentService {

	@Autowired
	private StudentBusinessServiceImpl studentBusinessServiceImpl;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Student saveStudent(@RequestBody Student student) {
		return studentBusinessServiceImpl.saveStudent(student);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Student getStudent(@PathVariable long id) {
		return studentBusinessServiceImpl.getStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Student> getStudent(@RequestParam String lastName,@RequestParam int age) {
		return studentBusinessServiceImpl.searchStudent(lastName, age);
	}

}
