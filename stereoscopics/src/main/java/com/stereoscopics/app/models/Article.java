package com.stereoscopics.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Article {
	@Id
	private String id;
    private String title;
	private String authors;
    private String content;
    private String genre;
   	private String date;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

   	@JsonProperty("Title")
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("Genre")
    public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonProperty("Authors")
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	@JsonProperty("Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonProperty("Date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}