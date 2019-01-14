package com.zy.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.zy.entity.Course;
import com.zy.entity.CourseList;
import com.zy.entity.CourseView;
import com.zy.entity.Student_Course;

@Mapper
public interface CourseDao {

	@Select("select * from course where co_id=#{co_id} ")
	public Course findById(String co_id);
	
	@Select("select * from course")
	public List<Course> findCourseAll();
	
	@SelectProvider(type=CourseSqlProvider.class,method="findCourseByMap")
	public List<CourseView> findCourseByMap(Map<String, List<String>> map);
	
	@Select("select * from student_course where s_id=#{s_id}")
	public List<Student_Course> findSelectedCourse(String s_id);
	
	@SelectProvider(type=CourseSqlProvider.class,method="findCourseList")
	public List<CourseList> findCourseList(Map<String, String> map);
	
	@Select("select count(*) from student_course where co_id=#{co_id}")
	public int countCourse(String co_id);
}
