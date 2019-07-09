package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Movie;
import com.bw.mapper.MovieDao;

@Service
public class MovieServiceimpl implements MovieService{
	@Resource
	private MovieDao dao;

	@Override
	public List<Movie> getMovieList(Map<String, Object> m) {
		// TODO Auto-generated method stub
		return dao.getMovieList(m);
	}

	@Override
	public int getState(Integer mid) {
		// TODO Auto-generated method stub
		return dao.getState(mid);
	}

	@Override
	public int getState1(Integer mid) {
		// TODO Auto-generated method stub
		return dao.getState1(mid);
	}

	@Override
	public int deleteAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.deleteAll(map);
	}
}
