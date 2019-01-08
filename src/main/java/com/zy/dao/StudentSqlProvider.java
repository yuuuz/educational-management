package com.zy.dao;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
* @author zy
* 2019年1月7日 下午1:05:23
*/
public class StudentSqlProvider {
	public String findByLikeName(String q_name){
		return new SQL() {
			{
				SELECT("*");
				FROM("student");
				if (!"".equals(q_name)) {
					WHERE(" s_name like #{q_name}");
				}
			}
		}.toString();
	}
	public String findByMap(Map<String, String> map) {
		String re = "select * from student where 1=1";
		String name = map.get("q_name");
		if (name != null && !"".equals(name)) {
			re += " and s_name like #{q_name}";
		}
		String q_id = map.get("q_id");
		if (q_id != null && !"".equals(q_id)){
			re += " and s_id = #{q_id}";
		}
		return re;
	}
}
