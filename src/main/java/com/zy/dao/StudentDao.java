package com.zy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.zy.entity.Student;

/**
* @author zy
* 2019年1月5日 下午3:29:11
*/
@Mapper
public interface StudentDao {
	//根据账号查询用户信息
	@Select("select * from student where s_id=#{s_id} ")
	public Student findById(String s_id);
	
	@Select("select * from student")
	public List<Student> findAll();
	
	@Select("select count(*) from student where s_name=#{s_name}")
	public int countByName(String s_name);
	
	//保存
	@Insert("insert into student(s_id,s_name) values(#{s_id},#{s_name})")
	public void save(Student student);
	
	// 根据编号删除数据
	@Delete("delete from student where s_id =#{s_id}")
	public void delete(String s_id);
	
	// 编辑保存
	@Update("update student set s_name=#{s_name} where s_id=#{s_id}")
	public void update(Student student);
	
	//根据条件进行查询
	// 动态sql 
	@SelectProvider(type=StudentSqlProvider.class,method="findByMap")
	public List<Student> findByMap(Map<String, String> map);
	
	@SelectProvider(type=TeacherSqlProvider.class,method="findByLikeName")
	public List<Student> findByLikeName(String q_name);
}
