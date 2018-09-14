package com.oscartran.restful_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oscartran.restful_api.entities.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {
	public Article findById(Long id);
}
