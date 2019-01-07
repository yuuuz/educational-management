package com.zy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.StudentDao;
import com.zy.entity.Student;

/**
* @author zy
* 2019年1月5日 下午3:32:10
*/
@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student findById(String id){
		Student student = null;
		try{
			student = studentDao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}
