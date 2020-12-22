package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Product;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;

	@Transactional
	public void save(Product product) {
		repo.save(product);
	}

	@Transactional(readOnly = true)
	public List<Product> listAll() {
		return (List<Product>) repo.findAll();
	}

	@Transactional(readOnly = true)
	public Product get(Long id) {
		return repo.findById(id).get();
	}

	@Transactional
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Transactional
	public List<Product> search(String keyword) {
		return repo.search(keyword);
	}
}
