package com.mountan.productList.Service;


import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Mapper.CategoryMapper;
import com.mountan.productList.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;



    public CategoryDTO CreateCategory(CategoryDTO categoryDTO){
       Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category = categoryRepository.save(category);
      return CategoryMapper.toCategoryDTO(category);



    }



}
