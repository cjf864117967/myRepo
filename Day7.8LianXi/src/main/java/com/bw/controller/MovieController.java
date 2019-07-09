package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Movie;
import com.bw.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {
	@Resource
	private MovieService service;
	
	@RequestMapping("/tolist.do")
	public String tolist(){
		return "list";
	}
	@RequestMapping("/list.do")
	public String getMovieList(ModelMap map,@RequestParam(defaultValue="1",required=false)Integer pageNum,String yname,String dopen,String dclose){
		Map<String, Object> m = new HashMap<String, Object>();
		if(pageNum==0){
			pageNum=1;
		}
		m.put("yname", yname);
		m.put("dopen", dopen);
		
		m.put("dclose", dclose);
		PageHelper.startPage(pageNum, 2);
		List<Movie> list = service.getMovieList(m);
		PageInfo<Movie> page = new PageInfo<Movie>(list);
		map.put("page", page);
		return "list";
		
	}
	@RequestMapping("/getState.do")
	public String getState(Integer mid){
		int num = service.getState(mid);
		return "redirect:/list.do";
	}
	@RequestMapping("/getState1.do")
	public String getState1(Integer mid){
		int num = service.getState1(mid);
		return "redirect:/list.do";
		
	}
	
	@RequestMapping("/deleteAll.do")
	@ResponseBody
	public Integer deleteAll(Integer[] ids){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		int num = service.deleteAll(map);
		return num;
		
	}
}
