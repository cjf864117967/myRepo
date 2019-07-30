/**
 * 
 */
package com.chenjifeng.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chenjifeng.cms.core.Page;
import com.chenjifeng.cms.domain.Article;
import com.chenjifeng.cms.domain.Category;
import com.chenjifeng.cms.domain.Channel;
import com.chenjifeng.cms.domain.Pictures;
import com.chenjifeng.cms.domain.Slide;
import com.chenjifeng.cms.domain.Special;
import com.chenjifeng.cms.service.AdminHomeService;
import com.chenjifeng.cms.service.ArticleService;
import com.chenjifeng.cms.service.SlideService;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	
	@Resource
	private AdminHomeService adminhomeService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		//默认首页显示热门文章
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(category == null && channel == null){
					conditions.setHot(true);
					
					//热门文章时显示幻灯片
					List<Slide> slides = slideService.getTops(5);
					model.addAttribute("slides", slides);
				}
			}
		});
		t1.start();
		
		//如果频道或分类不为空，则显示分类或频道数据
		Thread t2 = new Thread(new Runnable() {
			List<Article> articles = null;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(category != null){
					conditions.setCategory(new Category(category));
				}else if(channel != null){
					conditions.setChannel(new Channel(channel));
				}
				
				articles = articleService.gets(conditions, _page, null);
				model.addAttribute("articles", articles);
			}
		});
		t2.start();

		//---------------右侧放10条最新文章---------------------
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				 	
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("lastArticles", lastArticles);
			}
		});
		t3.start();
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(channel != null){
					model.addAttribute("channel", new Channel(channel));
				}
				model.addAttribute("category", category);
			}
		});
		t4.start();
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Article picturesArticles = new Article();
				picturesArticles.setDeleted(false);
				picturesArticles.setStatus(1);
				picturesArticles.setArticleType(1);	
				Page page = new Page(1, 3);
				page.setTotalCount(3);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> picture = articleService.gets(picturesArticles, page, null);
				model.addAttribute("picture", picture);
			}
		});
		
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//专题
		/*List<Special> special = articleService.getSpecial();
		model.addAttribute("special", special);*/
		
		return "home";
	}
	
	@RequestMapping("/article")
	public String article(Integer id,Model model){
		
		Article articles = new Article();
		articles.setDeleted(false);
		articles.setStatus(1);
		articles.setHot(true);
		 	
		Page lastArticlesPage = new Page(1, 5);
		lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
		
		List<Article> pictureArticles = articleService.gets(articles, lastArticlesPage, null);
		model.addAttribute("articles", pictureArticles);
		
		
		articleService.increaseHit(id);
		Article article = articleService.selectByPrimaryKey(id);
		if(article.getContent()!=null && article.getContent().length()>0){
			List<Pictures> picture = JSONArray.parseArray(article.getContent(), Pictures.class);
			model.addAttribute("picture", picture);
		}
		model.addAttribute("blog", article);
		return "blog";
		
	}
}
