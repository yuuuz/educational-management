package com.zy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.zy.entity.Course;
import com.zy.entity.StuCourseView;
import com.zy.entity.Student_Course;


@Mapper
public interface Student_CourseDao {

	@Insert("insert into student_course(s_c_id,s_id,co_id) values(#{s_c_id},#{s_id},#{co_id})")
	public void save(Student_Course student_Course);
	
	@Select("select * from stucourseview where s_id = #{s_id}")
	public List<StuCourseView> findById(String s_id);
	
	// 根据编号删除数据
	@Delete("delete from student_course where s_c_id =#{s_c_id}")
	public void delete(String s_c_id);
}
