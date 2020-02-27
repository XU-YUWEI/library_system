package com.xu.kinggame.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.xu.kinggame.entity.News;
import com.xu.kinggame.service.KindService;
import com.xu.kinggame.service.NewsService;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.Result;
import com.xu.kinggame.util.ResultGenerator;

@Controller
@RequestMapping("/admin")
public class NewsController {

	@Resource
	private NewsService newsService;
	@Resource
	private KindService kindService;
	
	@GetMapping("/news")
	public String list(HttpServletRequest request) {
		request.setAttribute("path", "news");
		return "admin/news";
	}
	@GetMapping("/news/edit")
	public String edit(HttpServletRequest request) {
		request.setAttribute("path", "edit");
		request.setAttribute("categories", kindService.getAllKinds());
		return "admin/edit";
	}
	
	@GetMapping("/news/list")
	@ResponseBody
	public Result list(@RequestParam Map<String, Object> params) {
		if(StringUtils.isEmpty(params.get("page"))||StringUtils.isEmpty("limit")) {
			 return ResultGenerator.genFailResult("参数异常");
		}
		PageQueryUtil pageUtil = new PageQueryUtil(params);
		return ResultGenerator.genSuccessResult(newsService.selectNews(pageUtil));
	}
	
	@PostMapping("/news/addNew")
	@ResponseBody
	public Result addNew(@RequestParam("newsTitle") String newsTitle,
           /* 这里的@RequestParam里面的参数名应该是与数据库里的一样*/@RequestParam("newsKindId") Long newsCategoryId,
            @RequestParam("newsContent") String newsContent,
            @RequestParam("newsImage") String newsCoverImage,
            @RequestParam("newsStatus") Byte newsStatus) {
		/*System.out.println(newsTitle+" "+newsCategoryId+" "+newsContent+" "+newsCoverImage+" "+newsStatus);*/
		if(StringUtils.isEmpty(newsTitle)) {
			return ResultGenerator.genFailResult("标题不能为空");
		}
		if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(newsCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        
        News news = new News();
        news.setNewTitle(newsTitle);
        news.setNewKindId(newsCategoryId);
        news.setNewContent(newsContent);
        news.setNewImage(newsCoverImage);
        news.setNewStatus(newsStatus);
        String anser = newsService.addNew(news);
        if("success".equals(anser)) {
        	return ResultGenerator.genSuccessResult();
        }else {
        	return ResultGenerator.genFailResult(anser);
        }
	}
	
	@GetMapping("/news/edit/{newsId}")
	public String edit(@PathVariable("newsId") Long id,HttpServletRequest request) {
		/*System.out.println(id);*/
		request.setAttribute("path", "edit");
		News news = newsService.selectNewsById(id);
		if(news==null) {
			return "error/error_400";
		}
		request.setAttribute("news", news);
		request.setAttribute("categories", kindService.getAllKinds());
        return "admin/edit";
	}
	
	
	
	@PostMapping("/news/update")
	@ResponseBody
	public Result update(@RequestParam("newsId") Long newsId,
			@RequestParam("newsTitle") String newsTitle,
            @RequestParam("newsKindId") Long newsCategoryId,
            @RequestParam("newsContent") String newsContent,
            @RequestParam("newsImage") String newsCoverImage,
            @RequestParam("newsStatus") Byte newsStatus) {
		/*System.out.println("ss");*/
		if(StringUtils.isEmpty(newsTitle)) {
			return ResultGenerator.genFailResult("标题不能为空");
		}
		if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(newsCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        
        News news = new News();
        news.setNewId(newsId);
        news.setNewTitle(newsTitle);
        news.setNewKindId(newsCategoryId);
        news.setNewContent(newsContent);
        news.setNewImage(newsCoverImage);
        news.setNewStatus(newsStatus);
        String anser = newsService.updateNew(news);
       /* System.out.println(anser);*/
        if("success".equals(anser)) {
        	return ResultGenerator.genSuccessResult();
        }else {
        	return ResultGenerator.genFailResult(anser);
        }
	}
	
	@PostMapping("/news/delete")
	@ResponseBody
	public Result delete(@RequestBody Integer[] ids) {
		if(ids.length<1) {
			return ResultGenerator.genFailResult("参数异常");
		}
		if (newsService.deleteNew(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
	}
}
