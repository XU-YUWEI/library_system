package com.xu.kinggame.service;

import com.xu.kinggame.entity.News;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.PageResult;

public interface NewsService {

	PageResult selectNews(PageQueryUtil pageUtil);

	String addNew(News news);


	String updateNew(News news);

	boolean deleteNew(Integer[] ids);

	News selectNewsById(Long id);

}
