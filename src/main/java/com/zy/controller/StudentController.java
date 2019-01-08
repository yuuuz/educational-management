package com.zy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zy.dao.StudentDao;
import com.zy.dao.TeacherDao;
import com.zy.entity.Student;
import com.zy.entity.Teacher;
import com.zy.service.StudentService;

/**
* @author zy
* 2019年1月7日 上午11:10:27
*/
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentDao studentDao;
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(name="q_id",defaultValue="")String s_id,
			@RequestParam(defaultValue="",name="q_name")String s_name,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,Model model){
		// 获取老师的信息
		String q_name = s_name;
		if (!"".equals(q_name)) {
			//模糊查询
			q_name = "%" + q_name + "%";
		}
		model.addAttribute("q_name",s_name);
		model.addAttribute("q_id",s_id);
		PageInfo<Student> pageData = studentService.pageQuery(s_id,q_name,pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return  "student/list";//转发到页面展示
	}
	
	/**
	 * 
	 * @param id 表示要修改的数据的编号
	 * @return
	 */
	//显示老师信息
	@RequestMapping("/view")
	public String view(String s_id,Model model){
		// 根据编号去查询老师信息
		Student student = studentDao.findById(s_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", student);
		return "student/view";//跳转显示页面
	}
	
	// 新增和修改
	// form表单
	// teacher来至于from表单的数据
	@RequestMapping("/save")
	public String save(Student student){
		//
		if(student.getS_id()==null||"".equals(student.getS_id())){
			student.setS_id("s"+System.currentTimeMillis());
			studentDao.save(student);// 保存
		}else{
			// 编辑操作
			studentDao.update(student);// 修改保存
		}
		return "forward:/student/list";// 返回列表页面
	}
	
	// 删除
	@RequestMapping("/delete")
	public String delete(String s_id,Model model){
		studentDao.delete(s_id);
		model.addAttribute("msg", "成功删除数据");
		return "forward:/student/list";// 返回列表页面
	}
	
	//跳转到编辑页面
	@RequestMapping("/edit")
	public String edit(String s_id,Model model){
		// 根据编号查询该教师信息
		Student student = studentDao.findById(s_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", student);
		return "student/edit";
	}
	
	// 验证姓名是否存在
	// 若存在返回yes
	// 若不存在返回no
	@RequestMapping("/isExist")
	@ResponseBody
	public String isExist(String s_name){
		int count = studentDao.countByName(s_name);
		if(count>0){
			return "yes";
		}else{
			return "no";
		}
	}
}
