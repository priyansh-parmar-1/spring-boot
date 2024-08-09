package com.publications.author.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.publications.author.entity.Author;
import com.publications.author.entity.Book;

public class OrderRequest {

	private Author author;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(Author author) {
		super();
		this.author = author;
	}

	public OrderRequest(
            @JsonProperty("name") String name,
            @JsonProperty("email") String url,
            @JsonProperty("bio") String bio,
            @JsonProperty("products") List<Book> books) {
			this.author = new Author(name, url, bio, books);
}
	
	
}
