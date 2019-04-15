package com.jarry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jarry.dao.StudentDao;

@Service
public class StudentService {

	@Autowired 
	private StudentDao studentDao ;
	
	@Transactional
	public void insert(String id) {
		studentDao.insertStudent(id);
		throw new RuntimeException("tttt");
	}
}
