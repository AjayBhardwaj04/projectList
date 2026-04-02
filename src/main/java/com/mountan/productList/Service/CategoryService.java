package com.mountan.productList.Service;


import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Mapper.CategoryMapper;
import com.mountan.productList.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public CategoryRepository categoryRepository;
    public CategoryDTO toCategoryDTO(CategoryDTO categoryDTO){
       Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category = categoryRepository.save(category);
       return categoryDTO;


    }



}
