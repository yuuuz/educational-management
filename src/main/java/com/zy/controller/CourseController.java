package com.zy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zy.dao.CourseDao;
import com.zy.dao.Student_CourseDao;
import com.zy.entity.Course;
import com.zy.entity.CourseList;
import com.zy.entity.CourseView;
import com.zy.entity.StuCourseView;
import com.zy.entity.Student_Course;
import com.zy.service.CourseService;
import com.zy.service.Student_CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseDao courseDao;
	@Autowired
	CourseService courseService;
	@Autowired
	Student_CourseDao student_CourseDao;
	@Autowired
	Student_CourseService student_CourseService;
	//·选课列表
	@RequestMapping("/prelist")
	public String prelist(String s_id,
			@RequestParam(defaultValue = "1") Integer pageNum, 
			@RequestParam(defaultValue = "5") Integer pageSize,Model model){
		List<Student_Course> student_courseList = courseDao.findSelectedCourse(s_id);
		PageInfo<CourseView> pageData = courseService.coursepagelist(student_courseList,pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return  "course/select_course";//转发到页面展示
	}
	//·选课提交
	@RequestMapping("/submit")
	public String submit(String s_id,HttpServletRequest request) {
		String [] selected = request.getParameterValues("selected");
		for(Integer i=0;selected!=null && i<selected.length;i++) {
			//查找选中课程对应id的课程信息
//			Course course = courseService.findById(selected[i]);
			//·保存到student_course表中
			Student_Course student_Course = new Student_Course();
			student_Course.setS_c_id("sc"+System.currentTimeMillis());
			student_Course.setS_id(s_id);
			student_Course.setCo_id(selected[i]);
			student_CourseDao.save(student_Course);
		}
		return "forward:/course/prelist";
	}
	//·显示已选课程列表
	@RequestMapping("/selectedlist")
	public String selectedlist(String s_id,
			@RequestParam(defaultValue = "1") Integer pageNum, 
			@RequestParam(defaultValue = "5") Integer pageSize,Model model){
		// 将数据放到model
		model.addAttribute("q_id",s_id);
		PageInfo<StuCourseView> pageData = student_CourseService.selectedpagelist(s_id,pageNum, pageSize);

		model.addAttribute("pageInfo", pageData);
		return  "course/selected_course";//转发到页面展示
	}
	//·退课
	@RequestMapping("/drop")
	public String drop(String s_c_id, Model model) {
		
		student_CourseDao.delete(s_c_id);
		model.addAttribute("msg", "成功退选课程");
		return "forward:/course/selectedlist";// 返回列表页面
	}
	
	//·教师课表
	@RequestMapping("/courselist")
	public String courselist(String t_id,
			@RequestParam(defaultValue = "1") Integer pageNum, 
			@RequestParam(defaultValue = "5") Integer pageSize,Model model){

		PageInfo<CourseList> pageData = courseService.courselist(t_id,pageNum, pageSize);

		model.addAttribute("pageInfo", pageData);
		return  "course/courselist";//转发到页面展示
	}	
}
