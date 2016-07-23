package com.billowsoft.recorder.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.billowsoft.recorder.bean.Article;
import com.billowsoft.recorder.service.ArticleService;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ArticleService  articleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		logger.debug("index() is executed!");
		return "index";
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String gotoPost(Map<String, Object> model) {
		logger.debug("post is executed!");
		model.put("article", new Article());
		return "doPost";
	}

	@RequestMapping(value = "/doPost", method = RequestMethod.POST)
	public String doPost(@ModelAttribute("article") Article article) {
		logger.debug("do post is executed!");
		articleService.saveArticle(article);
		return "index";
	}
	

}