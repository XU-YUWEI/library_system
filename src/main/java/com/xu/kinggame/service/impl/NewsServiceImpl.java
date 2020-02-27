package com.xu.kinggame.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xu.kinggame.dao.NewsMapper;
import com.xu.kinggame.entity.News;
import com.xu.kinggame.service.NewsService;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.PageResult;
@Service
public class NewsServiceImpl implements NewsService{

	@Resource
	private NewsMapper newMapper;
	@Override
	public PageResult selectNews(PageQueryUtil pageUtil) {
		List<News> list = newMapper.selectNews(pageUtil);
		int count = newMapper.selectCount(pageUtil);
		PageResult pageResult = new PageResult(list, count, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}
	@Override
	public String addNew(News news) {
		if(newMapper.addNew(news)>0) {
			return "success";
		}
		else {
			return "添加失败";
		}
	}
	@Override
	public String updateNew(News news) {
		News updatenew = newMapper.selectNewById(news.getNewId());
		/*System.out.println(news.getNewId());
		System.out.println(updatenew);
		System.out.println(news);*/
		if(updatenew==null) {
			return "数据不存在";
		}
		updatenew.setNewTitle(news.getNewTitle());
		updatenew.setNewKindId(news.getNewKindId());
		updatenew.setNewContent(news.getNewContent());
		updatenew.setNewImage(news.getNewImage());
		updatenew.setNewStatus(news.getNewStatus());
		if(newMapper.updateNew(updatenew)>0) {
			return "success";
		}else {
			return "修改失败";
		}
	}
	@Override
	public boolean deleteNew(Integer[] ids) {
		if(newMapper.deleteNew(ids)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public News selectNewsById(Long id) {
		News updatenew = newMapper.selectNewById(id);
		return updatenew;
		
	}

}
