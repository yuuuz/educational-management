package com.zy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.StudentDao;
import com.zy.dao.TeacherDao;
import com.zy.entity.Student;
import com.zy.entity.Teacher;

@Service
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;

	public Teacher findById(String t_id){
		Teacher teacher = null;
		try{
			teacher = teacherDao.findById(t_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}
	/**
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 每页要显示的最大记录数
	 * @return
	 */
	public PageInfo<Teacher> pageQuery(String q_id,String q_name,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		Map<String, String> map = new HashMap<>();
		map.put("q_name", q_name);
		map.put("q_id", q_id);
		List<Teacher> all = teacherDao.findByMap(map);				
		return new PageInfo<>(all);
	}
}
