package com.zy.entity;
/**
* @author zy
* 2019年1月7日 下午4:40:39
*/
import java.sql.Timestamp;

public class Notice {
	private Integer no_id;
	private String title;
	private Timestamp date;
	private String context;
	public Integer getNo_id() {
		return no_id;
	}
	public void setNo_id(Integer no_id) {
		this.no_id = no_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
