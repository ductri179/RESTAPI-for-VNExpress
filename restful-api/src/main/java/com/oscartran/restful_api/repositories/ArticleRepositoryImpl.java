package com.oscartran.restful_api.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.oscartran.restful_api.entities.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public Article findById(Long id) {
		return mongoOps.findById(id, Article.class);
	}

	@Override
	public List<Article> findAll() {
		return mongoOps.findAll(Article.class);
	}

	@Override
	public void save(Article article) {
		mongoOps.save(article);
	}

	@Override
	public void deleteAll() {
		mongoOps.dropCollection(Article.class);
	}

	@Override
	public void saveList(List<Article> articles) {
		mongoOps.insertAll(articles);
	}


}
