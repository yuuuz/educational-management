package com.zy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zy.entity.Notice;
import com.zy.entity.Student;


/**
* @author zy
* 2019年1月7日 下午5:38:16
*/
@Mapper
public interface NoticeDao {
	@Select("select * from notice")
	public List<Notice> findAll();
	
	@Select("select * from notice where no_id=#{no_id} ")
	public Notice findById(int no_id);
}
