package com.zy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zy.entity.Notice;


/**
* @author zy
* 2019年1月7日 下午5:38:16
*/
@Mapper
public interface NoticeDao {
	@Select("select * from notice")
	public List<Notice> findAll();
	
	@Select("select * from notice where no_id=#{no_id} ")
	public Notice findById(Integer no_id);
	
	@Insert("insert into notice(title,context) values(#{title},#{context})")
	public void save(Notice notice);
	
	@Update("update notice set title=#{title}, context=#{context} where no_id=#{no_id}")
	public void update(Notice notice);
	
	// 根据编号删除数据
	@Delete("delete from notice where no_id =#{no_id}")
	public void delete(Integer no_id);
		
}
