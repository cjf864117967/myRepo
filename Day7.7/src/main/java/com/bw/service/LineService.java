package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.bean.Area;
import com.bw.bean.Line;

public interface LineService {

	List<Area> getSheng();

	List<Area> getShi(Integer aid);

	List<Area> getXian(Integer aid);

	void addLine(Line line);

	List<Line> getLineList(Map<String, Object> m);

	void addzj(Map<String, Object> map);

	Line getLine(Integer uid);

	List<Area> getSheng1(Integer sheng);

	List<Area> getShi1(Integer shi);

	List<Area> getXian1(Integer xian);

	void addUserLine(Map<String, Object> map);

	int deleteAll(Integer ids);

	void deleteLine(Integer ids);

}
