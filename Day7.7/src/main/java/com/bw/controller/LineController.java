package com.bw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.bean.Area;
import com.bw.bean.Line;
import com.bw.service.LineService;
import com.bw.utils.FileUtils;

@Controller
public class LineController {
	@Resource
	private LineService service;
	
	@RequestMapping("/list.do")
	public String getLineList(ModelMap map,String mname,String tname,Integer sheng,Integer shi,Integer xian){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("mname", mname);
		m.put("tname", tname);
		m.put("sheng", sheng);
		m.put("shi", shi);
		m.put("xian", xian);
		List<Line> list = service.getLineList(m);
		map.put("list", list);
		return "list";
	}
	@RequestMapping("/getSheng.do")
	@ResponseBody
	public Map<String, Object> getSheng(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Area> list  = service.getSheng();
		map.put("list", list);
		return map;
		
	}
	
	@RequestMapping("/getShi.do")
	@ResponseBody
	public Map<String, Object> getShi(Integer aid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Area> list  = service.getShi(aid);
		map.put("list", list);
		return map;
	}
	
	
	@RequestMapping("/getXian.do")
	@ResponseBody
	public Map<String, Object> getXian(Integer aid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Area> list  = service.getXian(aid);
		map.put("list", list);
		return map;
	}
	
	
	@RequestMapping("/addLine.do")
	public String addLine(Line line,MultipartFile photo,HttpSession session,Integer uid) throws IllegalStateException, IOException{
		String limage = FileUtils.upload(photo, session);
		line.setLimage(limage);
		service.addLine(line);
		int lid=line.getLid();
//		System.out.println(lid);
//		System.out.println(uid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lid", lid);
		map.put("uid", uid);
		service.addzj(map);
		return "redirect:list.do";
		
	}
	@RequestMapping("/getLine.do")
	@ResponseBody
	public Map<String, Object> getLine(Integer lid){
		Line line = service.getLine(lid);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Area> sheng1 = service.getSheng1(line.getSheng());
		List<Area> sheng  = service.getSheng();
		List<Area> shi1 =service.getShi1(line.getShi());
		List<Area> xian1 = service.getXian1(line.getXian());
		map.put("line", line);
		map.put("sheng", sheng);
		map.put("shi1", shi1);
		map.put("xian1", xian1);
		return map;
		
	}
	@RequestMapping("/addUserLine.do")
	public String addUserLine(Integer lid,Integer uid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lid", lid);
		map.put("uid", uid);
		service.addUserLine(map);
		return "redirect:list.do";
		
	}
	@RequestMapping("/deleteAll.do")
	@ResponseBody
	public Integer deleteAll(Integer ids){
		int num = service.deleteAll(ids);
		service.deleteLine(ids);
		return num;
		
	}
	
	@RequestMapping("/showImg.do")
	public void showImg(String limage,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(limage, request, response);
	}
}
