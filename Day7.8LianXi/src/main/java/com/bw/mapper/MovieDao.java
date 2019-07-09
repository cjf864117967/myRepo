package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.bean.Movie;

public interface MovieDao {

	List<Movie> getMovieList(Map<String, Object> m);

	int getState(Integer mid);

	int getState1(Integer mid);
	
	int deleteAll(Map<String, Object> map);

}
