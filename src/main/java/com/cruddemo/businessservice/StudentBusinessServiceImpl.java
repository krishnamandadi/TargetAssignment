package com.cruddemo.businessservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cruddemo.dao.StudentRepository;
import com.cruddemo.model.Student;

@Component
public class StudentBusinessServiceImpl {

	@Autowired
	private StudentRepository studentRepo;

	public StudentBusinessServiceImpl() {

	}

	public StudentBusinessServiceImpl(StudentRepository studentRepo) {

		this.studentRepo = studentRepo;
	}

	public Student saveStudent(Student student) {

		if (isValid(student)) {
			return studentRepo.save(student);

		} else {
			throw new BadDataException("Not valid Student");
		}

	}

	public Student getStudent(long id) {

		Student student = this.studentRepo.findOne(id);
		if (student != null) {
			return student;
		} else {
			throw new StudentNotFoundException(String.valueOf(id));

		}

	}

	public List<Student> searchStudent(String lastName, int age) {

		// Just to demo jdk 8 collection feature filetring on java
		return studentRepo.findByLastName(lastName).stream().filter(student -> student.getAge() == age)
				.collect(Collectors.toList());

	}

	// Just for demo
	private boolean isValid(Student student) {

		if (student != null && student.getFirstName() != null && student.getFirstName().length() <= 10
				&& student.getLastName() != null && student.getLastName().length() <= 10 && student.getAge() >= 5
				&& student.getAge() <= 50) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

}
