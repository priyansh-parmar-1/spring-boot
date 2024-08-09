package com.example.College.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.College.dto.StudentRequest;
import com.example.College.entity.Student;
import com.example.College.exception.NoRecordsException;
import com.example.College.repository.StudentRepo;
import com.google.common.collect.Lists;

@Service
public class StudentService {

	@Autowired
	StudentRepo stdRepo;
	
	public List<Student> getAllStd(){
		List<Student> stds = Lists.newArrayList(stdRepo.findAll());
		if(stds.isEmpty()) {
			throw new NoRecordsException("No records for students");
		}
		return stds;
	}
	
	public boolean create(StudentRequest request) {
		try {
			stdRepo.save(request.getStudent());
		}
		catch(DataAccessException e) {
			System.out.print(e.getMessage());
		}
		return true;
	}
}
