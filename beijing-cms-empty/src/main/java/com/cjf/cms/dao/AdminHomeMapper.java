package com.cjf.cms.dao;

import java.util.List;
import java.util.Map;

import com.cjf.cms.domain.Article;
import com.cjf.cms.domain.Special;

public interface AdminHomeMapper {

	List<Special> queryAll();

	Special zjarticle(Integer id);

	List<Article> queryAllById(Integer id);

	void save(Map<String, Object> map);

	List<Special> getSpecial();

}