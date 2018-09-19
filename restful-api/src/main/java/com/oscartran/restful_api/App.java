package com.oscartran.restful_api;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.oscartran.restful_api.crawler.ArticlesCrawler;

@SpringBootApplication
public class App 
{
	private final static String url = "http://vnexpress.net";
	
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    	Runnable crawler = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Start crawling data.");
					context.getBean(ArticlesCrawler.class).crawlLatestArticles(url);
				} catch (BeansException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    	};
    	scheduler.scheduleAtFixedRate(crawler, 0, 60, TimeUnit.MINUTES);
    }
}
