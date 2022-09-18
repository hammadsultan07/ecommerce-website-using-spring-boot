package com.hammad.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammad.major.model.Product;
import com.hammad.major.repository.ProductRepo;


@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;

	
	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
	public void addProd(Product product)
	{
		productRepo.save(product);
	}
	public void deleteProd(long id)
	{
		productRepo.deleteById(id);
	}
	public Optional<Product> updateProduct(Long id)
	{
		return productRepo.findById(id);
	}
	/*public List<Product> getAllbyCat(int id)
	{
		return productRepo.findAllByCat(id);
	}*/
	}

