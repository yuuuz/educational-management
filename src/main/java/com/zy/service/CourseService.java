package com.zy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.CourseDao;
import com.zy.entity.Course;
import com.zy.entity.CourseList;
import com.zy.entity.CourseView;
import com.zy.entity.Student;
import com.zy.entity.Student_Course;


@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	public Course findById(String id){
		Course course = null;
		try{
			course = courseDao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	
	//·待选课程
	public PageInfo<CourseView> coursepagelist(List<Student_Course> student_courseList,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		Map<String, List<String>> map = new HashMap<>();
		List<String> id = new ArrayList<>();
		if (student_courseList != null ) {
			for(int i = 0;i<student_courseList.size();i++) {
				id.add(student_courseList.get(i).getCo_id());
			}
		}
		map.put("q_id",id);
		List<CourseView> all = courseDao.findCourseByMap(map);
//		List<Course> all = courseDao.findCourseAll();
		return new PageInfo<>(all);
	}
	
	public PageInfo<CourseList> courselist(String q_id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Map<String, String> map = new HashMap<>();
		map.put("q_id", q_id);
		List<CourseList> all = courseDao.findCourseList(map);
		for(int i=0;i<all.size();i++) {
			all.get(i).setCount(courseDao.countCourse(all.get(i).getCo_id()));
		}
		return new PageInfo<>(all);
	}
}
