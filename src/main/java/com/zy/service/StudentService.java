package com.zy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<Student> pageQuery(String q_id,String q_name,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		Map<String, String> map = new HashMap<>();
		map.put("q_name", q_name);
		map.put("q_id", q_id);
		List<Student> all = studentDao.findByMap(map);				
		return new PageInfo<>(all);
	}
}
