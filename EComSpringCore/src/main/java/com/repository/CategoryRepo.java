package com.repository;

import com.Mapper.CategoryMapper;
import com.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepo {
    private final CategoryMapper categoryMapper;
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepo(CategoryMapper categoryMapper, JdbcTemplate jdbcTemplate) {
        this.categoryMapper = categoryMapper;

        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Category> getAllCategories() {
        String sql = "select * from category";
        return jdbcTemplate.query(sql , categoryMapper);
    }

    public List<Category> getCategoryById(int categoryId) {
        String sql = "select * from category where id = ?";
        return jdbcTemplate.query(sql , categoryMapper , categoryId);
    }
}
