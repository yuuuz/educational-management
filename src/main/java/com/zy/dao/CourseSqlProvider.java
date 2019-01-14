package com.zy.dao;

import java.util.List;
import java.util.Map;

public class CourseSqlProvider {
	
	public String findCourseByMap(Map<String, List<String>> map) {
		String re = "select * from courseview where 1=1";
		List<String> qid = map.get("q_id");
		if (qid != null) {
			for(int i = 0;i<qid.size();i++) {
				String co_id = qid.get(i);
				if (co_id != null && !"".equals(co_id)){
					re += " and co_id <> " + co_id;
				}
			}
		}
		return re;
	}
	
	public String findCourseList(Map<String, String> map) {
		String re = "select * from course where 1=1";
		String q_id = map.get("q_id");
		if (q_id != null && !"".equals(q_id)){
			re += " and t_id = #{q_id}";
		}
		return re;
	}
}
