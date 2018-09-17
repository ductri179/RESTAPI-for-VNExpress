package com.oscartran.restful_api.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oscartran.restful_api.entities.Article;
import com.oscartran.restful_api.services.ArticleService;
import com.oscartran.restful_api.services.NextSequenceService;

@Service
public class ArticlesCrawler {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private NextSequenceService seqService;
	
	
	public ArticlesCrawler() {
		
	}
	
	public void crawlNewestArticles(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		List<Article> articles = new ArrayList<Article>();
		
		Elements elements = doc.select("article");
		System.out.println("Amount: " + elements.size());
		
		seqService.reset();
		for (Element ele : elements) {
			Article article = new Article();
			article.setId(seqService.getNextSequence("article"));
			article.setTitle(ele.select("h3 a[title]").text());
			article.setUrl(ele.select("h3 a[href]").attr("href"));
			article.setDescription(ele.select("h4").text());
			articles.add(article);
		}
		
		//Insert to the DB
		articleService.deleteAll();
		articleService.saveAll(articles);
		System.out.println("Start Craw data");
		
	}
	
}
