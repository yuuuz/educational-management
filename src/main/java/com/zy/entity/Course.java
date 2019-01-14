package com.zy.entity;
/**
* @author zy
* 2019年1月7日 下午10:03:22
*/
public class Course {
	private String co_id;
	private String t_id;
	private String mj_id;
	private String co_name;
	private String co_credit;
	private String co_period;
	private String co_type;
	
	public String getCo_type() {
		return co_type;
	}
	public void setCo_type(String co_type) {
		this.co_type = co_type;
	}
	public String getCo_id() {
		return co_id;
	}
	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getMj_id() {
		return mj_id;
	}
	public void setMj_id(String mj_id) {
		this.mj_id = mj_id;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getCo_credit() {
		return co_credit;
	}
	public void setCo_credit(String co_credit) {
		this.co_credit = co_credit;
	}
	public String getCo_period() {
		return co_period;
	}
	public void setCo_period(String co_period) {
		this.co_period = co_period;
	}
	
}
