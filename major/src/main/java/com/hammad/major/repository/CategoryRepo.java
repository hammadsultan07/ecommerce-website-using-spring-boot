package com.hammad.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hammad.major.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
