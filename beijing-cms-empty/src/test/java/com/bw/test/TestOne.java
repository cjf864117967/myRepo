package com.bw.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenjifeng.cms.domain.Special;
import com.chenjifeng.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestOne {
	
	
	@Resource
	private ArticleService articleservice;
	
	@Test
	public void test1(){
		List<Special> list = articleservice.getSpecial();
		for (Special special : list) {
			System.out.println(special);
		}
	}
}
