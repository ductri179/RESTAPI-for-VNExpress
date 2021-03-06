package com.oscartran.restful_api.repositories;

import java.util.List;

import com.oscartran.restful_api.entities.Article;

public interface ArticleRepository {
	public Article findById(Long id);
	public List<Article> findAll();
	public void save(Article article);
	public void deleteAll();
	public void saveList(List<Article> articles);
}
