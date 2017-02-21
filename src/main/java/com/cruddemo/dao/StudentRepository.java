package com.cruddemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cruddemo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByLastName(String lastName);
}
