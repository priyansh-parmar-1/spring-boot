package com.publications.author.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.publications.author.entity.Author;
import com.publications.author.exceptions.NoRecordsFoundException;
import com.publications.author.repository.AuthorRepository;
import com.publications.author.vo.OrderRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorService {

	@Autowired
	AuthorRepository authorRepo;
	
	
	public boolean add(OrderRequest authorVO) {
		
		Author author = new Author();
		BeanUtils.copyProperties(authorVO, author);
		try {
			authorRepo.save(author);
		}
		catch(DataAccessException dae){
			System.out.println(dae.getMessage());
		}
		
		return true;
	}
	
	public OrderRequest get(String name,String url) {
		Optional<Author> author = authorRepo.findByNameAndUrl(name, url);
		if(! author.isPresent()) {
			throw new NoRecordsFoundException("no records found for "+name);
		}
		OrderRequest authorVO = new OrderRequest();
		BeanUtils.copyProperties(author.get(), authorVO);
		return authorVO;
	}
	
	public OrderRequest findById(Integer id) {
		
		Optional<Author> author = authorRepo.findById(id);
		if(! author.isPresent()) {
			throw new NoRecordsFoundException("no records found for id "+id);
		}
		OrderRequest authorVO = new OrderRequest();
		BeanUtils.copyProperties(author, authorVO);
		return authorVO;
	}
	
	public List<OrderRequest> getAll(){
		
		List<Author> authors = Lists.newArrayList(authorRepo.findAll());
		if(authors.isEmpty()) {
			throw new NoRecordsFoundException("no records found ");
		}
		List<OrderRequest> authorVOs = new ArrayList<>();
		authors.forEach(author ->{
			OrderRequest authorVO = new OrderRequest();
			BeanUtils.copyProperties(author, authorVO);
			authorVOs.add(authorVO);
		});
		return authorVOs;
	}
}
