package com.zy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zy.dao.TeacherDao;
import com.zy.entity.Teacher;
import com.zy.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherDao teacherDao;

	@Autowired
	TeacherService teacherService;

	// 展示老师的信息(/teacher/list)
	// 如何将查询到的老师数据传递给页面
	// 使用model对象
	@RequestMapping("/list")
	public String list(@RequestParam(name = "q_id", defaultValue = "") String t_id,
			@RequestParam(defaultValue = "", name = "q_name") String t_name,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize,
			Model model) {
		// 获取老师的信息
		String q_name = t_name;
		if (!"".equals(q_name)) {
			// 模糊查询
			q_name = "%" + q_name + "%";
		}
		model.addAttribute("q_name", t_name);
		model.addAttribute("q_id", t_id);
		PageInfo<Teacher> pageData = teacherService.pageQuery(t_id, q_name, pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return "teacher/list";// 转发到页面展示
	}

	/**
	 * 
	 * @param id
	 *            表示要修改的数据的编号
	 * @return
	 */
	// 显示老师信息
	@RequestMapping("/view")
	public String view(String t_id, Model model) {
		// 根据编号去查询老师信息
		Teacher teacher = teacherDao.findById(t_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", teacher);

		return "teacher/view";// 跳转显示页面

	}

	// 新增和修改
	// form表单
	// teacher来至于from表单的数据
	@RequestMapping("/save")
	public String save(Teacher teacher) {
		//
		if (teacher.getT_id() == null || "".equals(teacher.getT_id())) {
			teacher.setT_id("t" + System.currentTimeMillis());
			teacherDao.save(teacher);// 保存
		} else {
			// 编辑操作
			teacherDao.update(teacher);// 修改保存
		}
		return "forward:/teacher/list";// 返回列表页面
	}

	// 删除
	@RequestMapping("/delete")
	public String delete(String t_id, Model model) {
		teacherDao.delete(t_id);
		model.addAttribute("msg", "成功删除数据");
		return "forward:/teacher/list";// 返回列表页面
	}

	// 跳转到编辑页面
	@RequestMapping("/edit")
	public String edit(String t_id, Model model) {
		// 根据编号查询该教师信息
		Teacher teacher = teacherDao.findById(t_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", teacher);
		return "teacher/edit";
	}

	// 验证姓名是否存在
	// 若存在返回yes
	// 若不存在返回no
	@RequestMapping("/isExist")
	@ResponseBody
	public String isExist(String t_name) {
		int count = teacherDao.countByName(t_name);
		if (count > 0) {
			return "yes";
		} else {
			return "no";
		}
	}

	@RequestMapping("/resetTeacherPasswordList")
	public String resetTeacherPasswordList(@RequestParam(name = "q_id", defaultValue = "") String t_id,
			@RequestParam(defaultValue = "", name = "q_name") String t_name,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize,
			Model model) {

		// 获取老师的信息
		String q_name = t_name;
		if (!"".equals(q_name)) {
			// 模糊查询
			q_name = "%" + q_name + "%";
		}
		model.addAttribute("q_name", t_name);
		model.addAttribute("q_id", t_id);
		PageInfo<Teacher> pageData = teacherService.pageQuery(t_id, q_name, pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return "teacher/resetTeacherPasswordList";
	}

	// 跳转到重置密码界面
	@RequestMapping("/reset")
	public String reset(String t_id, Model model) {
		// 根据编号去查询老师信息
		Teacher teacher = teacherDao.findById(t_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", teacher);

		return "teacher/reset";// 跳转显示页面
	}

	@RequestMapping("/saveTeacherPassword")
	public String saveTeacherPassword(String t_id, String newPassword, String confirmNewPassword,
			HttpServletRequest request) {
		// 根据编号去查询教师信息
		Teacher teacher = teacherDao.findById(t_id);
		if (newPassword.equals(confirmNewPassword)) {
			teacher.setT_pa(newPassword);
			teacherDao.updatePassword(teacher);
			return "forward:/teacher/resetTeacherPasswordList";
		} else {
			request.setAttribute("msg", "两次输入的密码不一致");
			return "teacher/reset";
		}
	}

	// 跳转到修改密码界面
	@RequestMapping("/resetPassword")
	public String resetPassword(String t_id, Model model) {
		Teacher teacher = teacherDao.findById(t_id);
		model.addAttribute("obj", teacher);
		return "teacher/resetPassword";
	}

	// 修改密码
	@RequestMapping("/savePassword")
	public String savePassword(String t_id, String oldPassword, String newPassword, String confirmNewPassword,
			HttpServletRequest request) {

		Teacher teacher = teacherDao.findById(t_id);
		// 旧密码正确
		if (oldPassword.equals(teacher.getT_pa())) {
			// 判断两次输入的新密码是否相同
			if (newPassword.equals(confirmNewPassword)) {
				teacher.setT_pa(newPassword);
				teacherDao.updatePassword(teacher);
				return "forward:/main_teacher";
			} else {
				request.setAttribute("msg", "两次输入的密码不一致");
				return "teacher/resetPassword";
			}
		} else { // 旧密码不正确
			request.setAttribute("msg", "原来的密码错误！");
			return "teacher/resetPassword";
		}
	}
}
