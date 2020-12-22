package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "SELECT c FROM Product c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.type LIKE '%' || :keyword || '%'" + " OR c.amount LIKE '%' || :keyword || '%'"
			+ " OR c.time LIKE '%' || :keyword || '%'")
	public List<Product> search(@Param("keyword") String keyword);

}
