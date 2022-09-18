package com.hammad.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hammad.major.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
	//List<Product> findAllByCat(int id);
}
