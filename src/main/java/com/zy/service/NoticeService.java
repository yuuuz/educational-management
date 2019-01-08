package com.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.NoticeDao;
import com.zy.entity.Notice;

/**
* @author zy
* 2019年1月7日 下午6:06:55
*/
@Service
public class NoticeService {
	@Autowired
	NoticeDao noticeDao;
	public PageInfo<Notice> pagelist(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Notice> all = noticeDao.findAll();
		return new PageInfo<>(all);
	}
}
