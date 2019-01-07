package com.zy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zy.entity.Admin;
import com.zy.entity.Student;

/**
* @author zy
* 2019年1月5日 下午3:29:11
*/
@Mapper
public interface StudentDao {
	//根据账号查询用户信息
	@Select("select * from student where s_id=#{id} ")
	public Student findById(String id);
}
