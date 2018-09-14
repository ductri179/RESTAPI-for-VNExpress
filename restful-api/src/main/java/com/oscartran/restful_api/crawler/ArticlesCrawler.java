package com.oscartran.restful_api.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ArticlesCrawler {
	
	public void crawlNewestArticles(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
	}
	
}
