package com.oscartran.restful_api;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.oscartran.restful_api.crawler.ArticlesCrawler;

@SpringBootApplication
@ComponentScan({"com.oscartran.restful_api.controllers", "com.oscartran.restful_api.services", "com.oscartran.restful_api.repositories", 
	"com.oscartran.restful_api.crawler"} )
public class App 
{
	private final static String url = "http://vnexpress.net";
	
	
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	try {
			context.getBean(ArticlesCrawler.class).crawlNewestArticles(url);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
