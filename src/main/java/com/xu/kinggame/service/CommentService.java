package com.xu.kinggame.service;

import com.xu.kinggame.entity.NewsComment;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.PageResult;

public interface CommentService {

	Boolean addComment(NewsComment newsComment);

	PageResult selectComment(PageQueryUtil pageQueryUtil);

	boolean deleteComment(Integer[] ids);

	boolean checkComment(Integer[] ids);

}
