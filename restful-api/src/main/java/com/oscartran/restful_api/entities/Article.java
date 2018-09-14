package com.oscartran.restful_api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="articles")
public class Article {
	
	@Id
	private Long id;
	private String title;
	private String description;
	private String url;
	
	public Article(Long id, String title, String des, String url) {
		this.id = id;
		this.title = title;
		this.description = des;
		this.url = url;
	}
	
	@Override
	public String toString() {
		return String.format("Article[id=%s, title=%s, description=%s, url=%s]", getId(), title, description, url);
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
