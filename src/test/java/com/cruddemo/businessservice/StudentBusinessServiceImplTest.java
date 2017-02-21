package com.cruddemo.businessservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cruddemo.dao.StudentRepository;
import com.cruddemo.model.Student;

public class StudentBusinessServiceImplTest {

	private StudentRepository studentRepository;
	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	private StudentBusinessServiceImpl studentBusinessServiceImpl;

	@Before
	public void setupMock() {
		studentRepository = mock(StudentRepository.class);
		student1 = new Student(1L, "James", "Britto", 10);
		student2 = new Student(2L, "John", "Britto", 15);
		student3 = new Student(null, "Jio", "Peter", 10);
		student4 = new Student(4L, "Dev", "Britto", 15);
		studentBusinessServiceImpl = new StudentBusinessServiceImpl(studentRepository);
		when(studentRepository.findOne(1L)).thenReturn(student1);
		when(studentRepository.findByLastName("Britto")).thenReturn(Arrays.asList(student1, student2, student4));
		when(studentRepository.save(student1)).thenReturn(student3);

	}

	@Test
	public void testFind() {
		Student s = studentBusinessServiceImpl.getStudent(1L);
		assertEquals(student1, s);
	}

	@Test(expected = BadDataException.class) 
	public void testvalid() {
		Student exceptionStudent = new Student(null, "James", "B", 1000);
		studentBusinessServiceImpl.saveStudent(exceptionStudent);
	}
	
	@Test
	public void testSerach() {
		List<Student> students = studentBusinessServiceImpl.searchStudent("Britto", 15);
		assertEquals(students.size(), 2);
	}

}
