/**
 * 
 */
package com.cjf.cms.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cjf.cms.core.Page;
import com.cjf.cms.dao.ArticleMapper;
import com.cjf.cms.domain.Article;
import com.cjf.cms.domain.Special;
import com.cjf.cms.domain.User;
import com.cjf.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	@Override
	public void increaseHit(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.increaseHit(id);
	}

	
	@Override
	public Article selectByPrimaryKey(Integer id) {
		
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> queryAll(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.queryAll(article);
	}

	@Override
	public void updateByKey(Article article) {
		// TODO Auto-generated method stub
		articleMapper.updateByKey(article);
	}

	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		articleMapper.save(article);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUserByKey(User user) {
		// TODO Auto-generated method stub
		articleMapper.updateUserByKey(user);
	}

	@Override
	public List<Article> queryAll1(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.queryAll1(article);
	}

	@Override
	public List<Article> selects(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.selects(article);
	}

	@Override
	public List<Special> getSpecial() {
		// TODO Auto-generated method stub
		return articleMapper.getSpecial();
	}
	
	
}
