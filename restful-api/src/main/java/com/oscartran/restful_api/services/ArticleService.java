package com.oscartran.restful_api.services;

import java.util.List;

import com.oscartran.restful_api.entities.Article;

public interface ArticleService {
	public List<Article> findAll();
	public Article findById(Long id);
	public void save(Article article);
	public void deleteAll();
	public void saveAll(List<Article> articles);
}
