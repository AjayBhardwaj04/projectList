package com.mountan.productList.Service;


import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Exception.categoryException;
import com.mountan.productList.Mapper.CategoryMapper;
import com.mountan.productList.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

//Create Category
    public CategoryDTO CreateCategory(CategoryDTO categoryDTO) {
         Optional<Category> optional = categoryRepository.findByName(categoryDTO.getName());
         Optional<Category> optional1 = categoryRepository.findById(categoryDTO.getId());
         if(optional.isPresent()) {
             throw new  categoryException ("category  Name this ["+ categoryDTO.getName()+ "]  already exists in Database" );
         }

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
