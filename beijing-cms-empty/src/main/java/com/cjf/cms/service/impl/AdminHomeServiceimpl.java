package com.cjf.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cjf.cms.dao.AdminHomeMapper;
import com.cjf.cms.domain.Article;
import com.cjf.cms.domain.Special;
import com.cjf.cms.service.AdminHomeService;
@Service
public class AdminHomeServiceimpl implements AdminHomeService{
	
	
	@Resource
	AdminHomeMapper AdminHomeMapper;
	
	@Override
	public List<Special> queryAll() {
		// TODO Auto-generated method stub
		return AdminHomeMapper.queryAll();
	}

	@Override
	public Special zjarticle(Integer id) {
		// TODO Auto-generated method stub
		return AdminHomeMapper.zjarticle(id);
	}

	@Override
	public List<Article> queryAllById(Integer id) {
		// TODO Auto-generated method stub
		return AdminHomeMapper.queryAllById(id);
	}

	@Override
	public void save(Map<String, Object> map) {
		// TODO Auto-generated method stub
		AdminHomeMapper.save(map);
	}

	@Override
	public List<Special> getSpecial() {
		// TODO Auto-generated method stub
		return AdminHomeMapper.getSpecial();
	}

}
