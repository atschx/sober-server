package com.atschx.adnetwork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atschx.adnetwork.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
