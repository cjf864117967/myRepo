package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Area;
import com.bw.bean.Line;
import com.bw.mapper.LineDao;

@Service
public class LineServiceimpl implements LineService{
	@Resource
	private LineDao dao;

	@Override
	public List<Area> getSheng() {
		// TODO Auto-generated method stub
		return dao.getSheng();
	}

	@Override
	public List<Area> getShi(Integer aid) {
		// TODO Auto-generated method stub
		return dao.getShi(aid);
	}

	@Override
	public List<Area> getXian(Integer aid) {
		// TODO Auto-generated method stub
		return dao.getXian(aid);
	}

	@Override
	public void addLine(Line line) {
		// TODO Auto-generated method stub
		dao.addLine(line);
	}

	@Override
	public List<Line> getLineList(Map<String, Object> m) {
		// TODO Auto-generated method stub
		return dao.getLineList(m);
	}

	@Override
	public void addzj(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dao.addzj(map);
	}

	@Override
	public Line getLine(Integer uid) {
		// TODO Auto-generated method stub
		return dao.getLine(uid);
	}

	@Override
	public List<Area> getSheng1(Integer sheng) {
		// TODO Auto-generated method stub
		return dao.getSheng1(sheng);
	}

	@Override
	public List<Area> getShi1(Integer shi) {
		// TODO Auto-generated method stub
		return dao.getShi1(shi);
	}

	@Override
	public List<Area> getXian1(Integer xian) {
		// TODO Auto-generated method stub
		return dao.getXian1(xian);
	}

	@Override
	public void addUserLine(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dao.addUserLine(map);
	}

	@Override
	public int deleteAll(Integer ids) {
		// TODO Auto-generated method stub
		return dao.deleteAll(ids);
	}

	@Override
	public void deleteLine(Integer ids) {
		// TODO Auto-generated method stub
		dao.deleteLine(ids);
	}
}
