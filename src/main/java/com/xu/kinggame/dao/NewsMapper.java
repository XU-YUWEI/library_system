package com.xu.kinggame.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xu.kinggame.entity.News;
import com.xu.kinggame.util.PageQueryUtil;

@Component
public interface NewsMapper {

	List<News> selectNews(PageQueryUtil pageUtil);

	int selectCount(PageQueryUtil pageUtil);

	int addNew(News news);

	News selectNewById(Long newId);

	int updateNew(News updatenew);

	int deleteNew(Integer[] ids);

}
