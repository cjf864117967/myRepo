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
		
		return "user-space/article_list";
		
	}
	@RequestMapping("/blog/edit")
	public String edit(Integer id,Model model){
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", article);
		return "user-space/blog_edit";
	}
	@RequestMapping("/blog/save")
	public String save(Article article,MultipartFile file,HttpServletRequest request,MultipartFile[] photo,String[] desc){
		List<Pictures> pictures = new ArrayList<Pictures>();
		for (int i = 0; i < desc.length; i++) {
			article.setArticleType(1);
			Pictures picture = new Pictures();
			String upload = FileUploadUtil.upload(request, photo[i]);
			picture.setPhoto(upload);
			picture.setDesc(desc[i]);
			pictures.add(picture);
		}
		
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
			article.setContent(JSONArray.toJSONString(pictures));
			System.out.println(article);
			articleService.save(article);
		}
		return "redirect:/my/blogs";
		
	}
	@RequestMapping("/blog/remove")
	public String remove(Integer id){
		articleService.deleteByPrimaryKey(id);
		return "redirect:/my/blogs";
		
	}
	@RequestMapping("/user/edit")
	public String edit(User user,String genderName){
		Gender gender = Gender.valueOf(genderName);
		user.setGender(gender);
		articleService.updateUserByKey(user);
		return "user-space/profile";
		
	}
	
	@RequestMapping("/hot")
	public String hot(Article article,Integer id,HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		article.setHot(true);
		List<Article> list = articleService.selects(article);
		model.addAttribute("blogs", list);
		return "user-space/article_list";
		
	}
	@RequestMapping("/status")
	public String status(Article article,Integer id,HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		article.setStatus(1);
		List<Article> list = articleService.selects(article);
		model.addAttribute("blogs", list);
		
		return "user-space/article_list";	
	}
	
	
	
	
	@RequestMapping("/deleted")
	public String deleted(Article article,Integer id,HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		article.setDeleted(true);
		List<Article> list = articleService.selects(article);
		model.addAttribute("blogs", list);
		return "user-space/article_list";
		
	}
	@RequestMapping("/profile/avatar")
	public String avatar(Model model,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		model.addAttribute("user", user);
		return "user-space/avatar";
	}
	@RequestMapping("/addUserPhoto")
	public String addUserPhoto(User u,MultipartFile file,HttpServletRequest request){
		String upload = FileUploadUtil.upload(request, file);
			if(!upload.equals("")){
				u.setPictures(upload);
			}
		userService.addUserPhoto(u);
		User user = userService.get(u.getId());
		request.getSession().setAttribute(Constant.LOGIN_USER, user);
		System.out.println(u);
		return "redirect:/my/profile/avatar";
		
	}
}
