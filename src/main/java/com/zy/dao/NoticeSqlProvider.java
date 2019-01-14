package com.zy.dao;

/**
* @author zy
* 2019年1月13日 下午6:27:27
*/
public class NoticeSqlProvider {
	public String deleteAll(String no_id){
		String re = "delete from notice where no_id in ("+no_id+")";
		return re;
	}
}
