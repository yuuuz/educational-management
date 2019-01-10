package com.zy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zy.dao.AdminDao;
import com.zy.entity.Admin;



/**
* @author zy
* 2019年1月7日 上午11:10:27
*/
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired 
	AdminDao adminDao;

	
	//跳转到修改密码界面
	@RequestMapping("/resetPassword")
	public String resetPassword(String m_id,Model model) {
		// 根据编号去查询管理员信息
		Admin admin = adminDao.findById(m_id);
		model.addAttribute("obj", admin);
		return  "admin/resetPassword";
	}
	
	//修改密码
	@RequestMapping("/savePassword")
	public String savePassword(String m_id,String oldPassword,String newPassword,String confirmNewPassword,HttpServletRequest request) {
		
		Admin admin = adminDao.findById(m_id);
		//旧密码正确
		if(oldPassword.equals(admin.getM_pa())) {
			//判断两次输入的新密码是否相同
			if (newPassword.equals(confirmNewPassword)) {
				admin.setM_pa(newPassword);
				adminDao.update(admin);
				request.setAttribute("msg", "修改密码成功");
				return "admin/resetPassword";
			}else {
				request.setAttribute("msg", "两次输入的密码不一致");
				return "admin/resetPassword";
			}
			
		}else {  //旧密码不正确
			request.setAttribute("msg", "原来的密码错误！");
			return "admin/resetPassword";
		}
	}
	
	
}
