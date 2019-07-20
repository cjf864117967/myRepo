/**
 * 
 */
package com.cjf.cms.web.controllers;

import java.io.File;
import java.io.IOException;
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

import com.cjf.cms.core.Page;
import com.cjf.cms.domain.Article;
import com.cjf.cms.domain.Category;
import com.cjf.cms.domain.Channel;
import com.cjf.cms.domain.User;
import com.cjf.cms.service.ArticleService;
import com.cjf.cms.utils.FileUploadUtil;
import com.cjf.cms.utils.PageHelpUtil;
import com.cjf.cms.web.Constant;
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
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	
	@RequestMapping("/blogs")
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
	@RequestMapping("/blog/edit")
	public String edit(Integer id,Model model){
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", article);
		return "user-space/blog_edit";
	}
	@RequestMapping("/blog/save")
	public String save(Article article,MultipartFile file,HttpServletRequest request){
		
		String upload2 = FileUploadUtil.upload(request, file);
		if(!upload2.equals("")){
			article.setPicture(upload2);
		}
		if(article.getId()!=null){
			//修改文章
			articleService.updateByKey(article);
		}else{
			article.setHits(0);//第一次点击数
			article.setHot(true);//是否为热门文章
			article.setStatus(1);//是否通过审核
			article.setDeleted(false);//是否被删除
			article.setCreated(new Date());//文章发布时间
			//发布文章
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			article.setAuthor(user);
			articleService.save(article);
		}
		return "redirect:/my/blogs";
		
	}
}
