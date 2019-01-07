package com.zy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.AdminDao;
import com.zy.entity.Admin;

/**
* @author zy
* 2019年1月4日 下午4:11:15
*/
@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;

	public Admin findById(String id){
		Admin admin = null;
		try{
			admin = adminDao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
//	public boolean login(User user) {
//			// 找到
//			// 验证密码
//			if (password.equals(user.getPassword())) {
//				// 验证成功
//				// 将用户信息放入session会话
//				request.getSession().setAttribute("loginUser", user);
//				if ("1".equals(user.getUserType())) {
//					return "main_admin";// 系统管理
//				} else if ("2".equals(user.getUserType())) {
//					return "main_teacher";// 老师管理
//				} else {
//					// 学生界面
//					return "main_student";
//				}
//
//			} else {
//				// 验证密码失败
//				request.setAttribute("errorMsg", "密码错误");
//				return "login";
//			}
//	}
}
