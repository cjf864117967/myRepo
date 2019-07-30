/**
 * 
 */
package com.chenjifeng.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.chenjifeng.cms.core.Page;
import com.chenjifeng.cms.domain.Article;
import com.chenjifeng.cms.domain.Category;
import com.chenjifeng.cms.domain.Channel;
import com.chenjifeng.cms.domain.Pictures;
import com.chenjifeng.cms.domain.User;
import com.chenjifeng.cms.metas.Gender;
import com.chenjifeng.cms.service.ArticleService;
import com.chenjifeng.cms.service.UserService;
import com.chenjifeng.cms.utils.FileUploadUtil;
import com.chenjifeng.cms.utils.PageHelpUtil;
import com.chenjifeng.cms.web.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(HttpServletRequest request,User user,Model model){
		User userLogin = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		User u = userService.selectById(userLogin.getId());
		model.addAttribute("user", u);
		return "user-space/profile";
	}
	
	@RequestMapping("/searchblogs")
	public String blogs(Model model,HttpSession session,@RequestParam(value="page",defaultValue="1")Integer page ){
		Article article = new Article();
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		//当前用户发布的所有文章
		//分页信息
		PageHelper.startPage(page, 3);
		List<Article> articles = articleService.queryAll(article);
		PageInfo<Article> pageInfo = new PageInfo<Article>(articles,3);
		String pageList = PageHelpUtil.page("blogs", pageInfo);
		model.addAttribute("blogs", articles);
		model.addAttribute("pageList", pageList);
		
		return "user-space/blog_list";
		
	}
}
