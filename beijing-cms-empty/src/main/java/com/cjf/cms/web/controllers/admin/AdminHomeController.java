/**
 * 
 */
package com.cjf.cms.web.controllers.admin;

import java.util.HashMap;
import java.util.List;





import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;







import com.cjf.cms.domain.Article;
import com.cjf.cms.domain.Special;
import com.cjf.cms.web.controllers.PassportController;
import com.cjf.cms.service.AdminHomeService;
import com.cjf.cms.service.ArticleService;
/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	@Autowired
	AdminHomeService AdminHomeService;
	@Autowired
	ArticleService articleService;

	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	@RequestMapping("/categories")
	public String categories(){
		return "article/user-manage";
	}
	
	@RequestMapping("/articleManage")
	public String articleManage(){
		return "article/articleManage";
	}
	@RequestMapping("/ztManage")
	public String ztManage(Model model){
		
		List<Special> list = AdminHomeService.queryAll();
		model.addAttribute("list", list);
		return "article/ztManage";
	}
	@RequestMapping("/zjarticle")
	public String zjarticle(Integer id,Model model){
		Special special = AdminHomeService.zjarticle(id);
		model.addAttribute("special", special);
		List<Article> list = AdminHomeService.queryAllById(id);
		model.addAttribute("list", list);
		return "article/zjarticle";
	}
	@RequestMapping("/addArticle")
	public String addArticle(Integer sid,Integer aid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("aid", aid);
		AdminHomeService.save(map);
		return "article/ztManage";
		
	}
}
