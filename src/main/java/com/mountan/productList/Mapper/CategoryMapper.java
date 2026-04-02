package com.mountan.productList.Mapper;

import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;

public class CategoryMapper {
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category(); // "Category " this Category import from Entity Category
        category.setName(categoryDTO.getName());
        return category;

    }
}
