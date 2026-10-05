package com.service;

import com.exception.InvalidListException;
import com.model.Category;
import com.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getCategory() {
        return categoryRepo.getAllCategories();
    }

    public Category getCategoryById(int categoryId) {
        List<Category> categoryList = categoryRepo.getCategoryById(categoryId);
        if(categoryList == null || categoryList.isEmpty()){
            throw new InvalidListException("List given is null or empty");
        }
        return categoryList.getFirst();
    }
}
