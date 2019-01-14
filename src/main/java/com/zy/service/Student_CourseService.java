package com.zy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.Student_CourseDao;
import com.zy.entity.StuCourseView;
import com.zy.entity.Student_Course;

@Service
public class Student_CourseService {
	@Autowired
	Student_CourseDao student_CourseDao;

	//·已选课程
	public PageInfo<StuCourseView> selectedpagelist(String s_id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<StuCourseView> all = student_CourseDao.findById(s_id);
		return new PageInfo<>(all);
	}
}
