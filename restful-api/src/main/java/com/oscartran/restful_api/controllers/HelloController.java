package com.oscartran.restful_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oscartran.restful_api.entities.Article;
import com.oscartran.restful_api.repositories.ArticleRepository;
import com.oscartran.restful_api.services.NextSequenceService;

@Controller
public class HelloController {
	
	@Autowired
	private ArticleRepository repo;
	@Autowired
	private NextSequenceService seqService;

	@GetMapping("/hello")
	@ResponseBody
	public Article Hello() {
		repo.save(new Article(seqService.getNextSequence("article"), "title", "description", "http://blahblah.com"));
		Article article = repo.findById(1L);
		return article;
	}
	
}
