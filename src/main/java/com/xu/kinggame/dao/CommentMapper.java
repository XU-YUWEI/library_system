package com.xu.kinggame.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xu.kinggame.entity.NewsComment;
import com.xu.kinggame.util.PageQueryUtil;

@Component
public interface CommentMapper {

	int addComment(NewsComment newsComment);

	List<NewsComment> selectComment(PageQueryUtil pageQueryUtil);

	int selectCommentCount(PageQueryUtil pageQueryUtil);

	int deleteComment(Integer[] ids);

	int checkComment(Integer[] ids);

}
