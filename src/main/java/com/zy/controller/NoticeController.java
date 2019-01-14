package com.zy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zy.dao.NoticeDao;
import com.zy.dao.NoticeSqlProvider;
import com.zy.entity.Notice;
import com.zy.service.NoticeService;

/**
* @author zy
* 2019年1月7日 下午5:49:31
*/
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	NoticeDao noticeDao;
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,Model model){
		// 获取老师的信息
		PageInfo<Notice> pageData = noticeService.pagelist(pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return  "notice/list";//转发到页面展示
	}
	
	@RequestMapping("/mlist")
	public String mlist(@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,Model model){
		// 获取老师的信息
		PageInfo<Notice> pageData = noticeService.pagelist(pageNum, pageSize);
		// 将数据放到model
		model.addAttribute("pageInfo", pageData);
		return  "notice/mlist";//转发到页面展示
	}
	
	@RequestMapping("/view")
	public String view(Integer no_id,Model model){
		// 根据编号去查询老师信息
		Notice notice = noticeDao.findById(no_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", notice);
		return "notice/view";//跳转显示页面
	}
	
	@RequestMapping("/save")
	public String save(Notice notice){
		//
		if(notice.getNo_id()== null){
			System.out.println(notice.getNo_id());
			noticeDao.save(notice);// 保存
		}else{
			// 编辑操作
			noticeDao.update(notice);// 修改保存
		}
		return "forward:/notice/mlist";// 返回列表页面
	}
	
	@RequestMapping("/delete")
	public String delete(Integer no_id,Model model){
		noticeDao.delete(no_id);
		model.addAttribute("msg", "成功删除数据");
		return "forward:/notice/mlist";// 返回列表页面
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll(String no_id,Model model){
		noticeDao.deleteAll(no_id);
		model.addAttribute("msg", "成功批量删除数据");
		return "forward:/notice/mlist";// 返回列表页面
	}
	//跳转到编辑页面
	@RequestMapping("/edit")
	public String edit(Integer no_id,Model model){
		// 根据编号查询该教师信息
		Notice notice = noticeDao.findById(no_id);
		// 将查询的老师数据放入model中
		model.addAttribute("obj", notice);
		return "notice/edit";
	}
}
