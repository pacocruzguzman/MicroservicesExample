package com.remi.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remi.store.entity.Category;
import com.remi.store.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByCategory(Category category);
}
