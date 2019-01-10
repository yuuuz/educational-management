package com.zy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zy.entity.Admin;

/**
* @author zy
* 2019年1月4日 下午4:11:48
*/
@Mapper
public interface AdminDao {
	//根据账号查询用户信息
	@Select("select * from manager where m_id=#{id} ")
	public Admin findById(String id);
	
	@Update("update manager set m_pa=#{m_pa} where m_id=#{m_id}")
	public void update(Admin admin);
}
