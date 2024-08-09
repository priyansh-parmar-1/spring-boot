package com.publications.author.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.publications.author.entity.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer>{

	Optional<Author> findByNameAndUrl(String name,String url);
}
