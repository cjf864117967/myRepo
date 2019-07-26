package com.cjf.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjf.cms.domain.Category;
import com.cjf.cms.domain.Channel;
import com.cjf.cms.service.ChannelCategoryService;

@Controller
public class ChannelCategoryController {
	@Resource
	private ChannelCategoryService ccservice;
	
	@RequestMapping("/queryAllChannel")
	@ResponseBody
	public List<Channel> queryAllChannel(){
		List<Channel> list = ccservice.getChannels();
		return list;
		
	}
	@RequestMapping("/queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channel){
		List<Category> list = ccservice.getCategories(channel);
		return list;
	}
}	