package com.oscartran.restful_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oscartran.restful_api.entities.Article;
import com.oscartran.restful_api.services.ArticleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getlatest", produces = "application/json")
	@ApiOperation("Returns list of all latest articles of vnexpress.")
	public List<Article> getLatestArticles() {
		List<Article> articles = articleService.findAll();
		return articles;
	}
	
}
