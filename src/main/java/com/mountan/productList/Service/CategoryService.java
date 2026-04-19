package com.mountan.productList.Service;


import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Mapper.CategoryMapper;
import com.mountan.productList.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryDTO CreateCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
// get all category
    public List<CategoryDTO> getAllCategory(){
       return categoryRepository.findAll().stream().map(CategoryMapper ::toCategoryDTO).toList();
    }
// get category by id

public CategoryDTO getByIdCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("CATEGORY NOR FOUND"));
         return CategoryMapper.toCategoryDTO(category);
//        categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("CATEGORY NOT FOUND "));
}

// delete category by id
    public String  categoryDeleteById(Long id){
        categoryRepository.deleteById(id);
        return " CATEGORY " + id +" has ben deletes";



    }




}
