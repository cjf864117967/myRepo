package com.chenjifeng.cms.service;

import java.util.List;
import java.util.Map;

import com.chenjifeng.cms.domain.Article;
import com.chenjifeng.cms.domain.Special;

public interface AdminHomeService {

	List<Special> queryAll();

	Special zjarticle(Integer id);

	List<Article> queryAllById(Integer id);

	void save(Map<String, Object> map);

	List<Special> getSpecial();

}
