package com.publications.author.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Authors", uniqueConstraints = @UniqueConstraint
	(columnNames = {"name","url"} ))
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String url;
	private String bio;
	
	@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
	@JoinColumn(name="ab_fk",referencedColumnName= "id")
	private List<Book> books;
	
	
	
	
	public Author(String name, String url, String bio, List<Book> books) {
		super();
		this.name = name;
		this.url = url;
		this.bio = bio;
		this.books = books;
	}


	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", url=" + url + ", bio=" + bio + ", books=" + books + "]";
	}
	
	
	
}
