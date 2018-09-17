package com.oscartran.restful_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscartran.restful_api.entities.Article;
import com.oscartran.restful_api.repositories.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Override
	public List<Article> findAll() {
		return articleRepo.findAll();
	}

	@Override
	public Article findById(Long id) {
		return articleRepo.findById(id);
	}

	@Override
	public void save(Article article) {
		articleRepo.save(article);
	}

	@Override
	public void deleteAll() {
		articleRepo.deleteAll();
	}

	@Override
	public void saveAll(List<Article> articles) {
		articleRepo.saveList(articles);
	}

}
