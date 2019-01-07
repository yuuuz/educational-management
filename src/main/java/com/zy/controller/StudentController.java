package com.zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author zy
* 2019年1月7日 上午11:10:27
*/
@Controller
@RequestMapping("/student")
public class StudentController {

	// 跳转到考试管理界面
	@RequestMapping("/list")
	public String list(){
		return "student/stu_list";
	}
}
