package com.tcoshop.service.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcoshop.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}
