package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.bean.Movie;

public interface MovieService {

	List<Movie> getMovieList(Map<String, Object> m);

	int getState(Integer mid);

	int getState1(Integer mid);

	int deleteAll(Map<String, Object> map);

}
