package com.zy.dao;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
* @author zy
* 2019年1月3日 下午5:54:56
*/
public class TeacherSqlProvider {
	public String findByLikeName(String q_name){
		return new SQL() {
			{
				SELECT("*");
				FROM("teacher");
				if (!"".equals(q_name)) {
					WHERE(" t_name like #{q_name}");
				}
			}
		}.toString();
	}
	public String findByMap(Map<String, String> map) {
		String re = "select * from teacher where 1=1";
		String name = map.get("q_name");
		if (name != null && !"".equals(name)) {
			re += " and t_name like #{q_name}";
		}
		String q_id = map.get("q_id");
		if (q_id != null && !"".equals(q_id)){
			re += " and t_id = #{q_id}";
		}
		return re;
	}
	public static void main(String[] args) {
		TeacherSqlProvider teacherSqlProvider=new TeacherSqlProvider();
		System.out.println(teacherSqlProvider.findByLikeName("无锡与"));
	}
}
