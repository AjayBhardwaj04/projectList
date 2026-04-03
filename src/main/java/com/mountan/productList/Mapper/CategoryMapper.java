package com.mountan.productList.Mapper;

import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.getProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }

    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category(); // "Category " this Category import from Entity Category
        category.setName(categoryDTO.getName());
        return category;

    }
}
