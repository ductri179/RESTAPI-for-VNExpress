package com.oscartran.restful_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oscartran.restful_api.entities.Article;
import com.oscartran.restful_api.services.ArticleService;
import com.oscartran.restful_api.services.NextSequenceService;

@Controller
public class HelloController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private NextSequenceService seqService;

	@GetMapping("/hello")
	@ResponseBody
	public List<Article> Hello() {
		articleService.save(new Article(seqService.getNextSequence("article"), "title", "description", "http://blahblah.com"));
		List<Article> articles = articleService.findAll();
		return articles;
	}
	
}
