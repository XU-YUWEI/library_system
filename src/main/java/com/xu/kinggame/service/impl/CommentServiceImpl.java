package com.xu.kinggame.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xu.kinggame.dao.CommentMapper;
import com.xu.kinggame.entity.NewsComment;
import com.xu.kinggame.service.CommentService;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.PageResult;

@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;

	@Override
	public Boolean addComment(NewsComment newsComment) {
		return commentMapper.addComment(newsComment)>0;
	}

	@Override
	public PageResult selectComment(PageQueryUtil pageQueryUtil) {
		List<NewsComment> list = commentMapper.selectComment(pageQueryUtil);
		int count = commentMapper.selectCommentCount(pageQueryUtil);
		PageResult pageResult = new PageResult(list, count, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
		/*System.out.println(pageResult);*/
		return pageResult;
	}

	@Override
	public boolean deleteComment(Integer[] ids) {
		return commentMapper.deleteComment(ids)>0;
	}

	@Override
	public boolean checkComment(Integer[] ids) {
		return commentMapper.checkComment(ids)>0;
	}

	
	

}
