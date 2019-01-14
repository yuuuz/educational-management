package com.zy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zy.entity.Admin;
import com.zy.entity.Student;
import com.zy.entity.Teacher;
import com.zy.service.AdminService;
import com.zy.service.StudentService;
import com.zy.service.TeacherService;

@Controller
public class LoginController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	
	// 处理登录请求
	@RequestMapping("/login")
	public String login(String username,String password,HttpServletRequest request) {
		String user = request.getParameter("users");
		System.out.println(user);
		if (user!=null && user.equals("student")) {
			Student student = studentService.findById(username);
			if (student == null) {
				// 没有找到，返回登录界面
				request.setAttribute("errorMsg", "没有找到对应的用户信息");
				return "login";
			} else {
				// 找到
				// 验证密码
				if (password.equals(student.getS_pa())) {
					// 验证成功
					// 将用户信息放入session会话
					request.getSession().setAttribute("loginUser", student);
					return "redirect:/main_stu.jsp";// 系统管理
				}else {
					// 验证密码失败
					request.setAttribute("errorMsg", "密码错误");
					return "login";
				}
			}
		}else if (user!=null && user.equals("teacher")) {
			Teacher teacher = teacherService.findById(username);
			if (teacher == null) {
				// 没有找到，返回登录界面
				request.setAttribute("errorMsg", "没有找到对应的用户信息");
				return "login";
			} else {
				// 找到
				// 验证密码
				if (password.equals(teacher.getT_pa())) {
					// 验证成功
					// 将用户信息放入session会话
					request.getSession().setAttribute("loginUser", teacher);
					return "redirect:/main_teacher.jsp";// 系统管理
				}else {
					// 验证密码失败
					request.setAttribute("errorMsg", "密码错误");
					return "login";
				}
			}
		}else if (user!=null && user.equals("admin")) {

			Admin admin = adminService.findById(username);
			if (admin == null) {
				// 没有找到，返回登录界面
				request.setAttribute("errorMsg", "没有找到对应的用户信息");
				return "login";
			} else {
				// 找到
				// 验证密码
				if (password.equals(admin.getM_pa())) {
					// 验证成功
					// 将用户信息放入session会话
					request.getSession().setAttribute("loginUser", admin);
					return "redirect:/main_admin.jsp";// 系统管理
				}else {
					// 验证密码失败
					request.setAttribute("errorMsg", "密码错误");
					return "login";
				}
			}	
		}
		return "login";
	}

	@RequestMapping("/logout")
	// 处理系统用户退出
	public String logout(HttpServletRequest request) {
		// 将用户从session会话中清除
		request.getSession().removeAttribute("loginUser");
		// 重定向到登录
		return "redirect:" + request.getContextPath() + "/login";
	}
}
