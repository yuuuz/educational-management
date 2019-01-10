package com.zy.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.zy.entity.Teacher;

@Mapper
public interface TeacherDao {
	@Select("select * from teacher")
	public List<Teacher> findAll();
	
	@Select("select * from teacher where t_id=#{t_id}")
	public Teacher findById(String t_id);
	
	@Select("select count(*) from teacher where t_name=#{t_name}")
	public int countByName(String t_name);
	
	//保存
	@Insert("insert into teacher(t_id,t_name) values(#{t_id},#{t_name})")
	public void save(Teacher teacher);
	
	// 根据编号删除数据
	@Delete("delete from teacher where t_id =#{t_id}")
	public void delete(String t_id);
	
	// 编辑保存
	@Update("update teacher set t_name=#{t_name} where t_id=#{t_id}")
	public void update(Teacher teacher);
	
	//更新密码
	@Update("update teacher set t_pa=#{t_pa} where t_id=#{t_id}")
	public void updatePassword(Teacher teacher);
	
	//根据条件进行查询
	// 动态sql 
	@SelectProvider(type=TeacherSqlProvider.class,method="findByMap")
	public List<Teacher> findByMap(Map<String, String> map);
	
	@SelectProvider(type=TeacherSqlProvider.class,method="findByLikeName")
	public List<Teacher> findByLikeName(String q_name);

}
