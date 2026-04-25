package com.mountan.productList.Controller;

import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.DTO.ProductDTO;
import com.mountan.productList.Exception.categoryException;
import com.mountan.productList.Mapper.CategoryMapper;
import com.mountan.productList.Service.CategoryService;
import com.mountan.productList.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private ProductService productService;
    private  CategoryService categoryService;
// get all category
    @GetMapping
    public List<CategoryDTO> getAllCategory(){
        return
                categoryService.getAllCategory();
    }
    @PostMapping
    public ResponseEntity< ?> createCategory( @Validated @RequestBody CategoryDTO categoryDTO){
      //  try {
            CategoryDTO saveCategory = categoryService.CreateCategory(categoryDTO);
            return  ResponseEntity.status( HttpStatus.CREATED).body(saveCategory);
            //categoryAlreadyExistsExceptions
     ///   }catch (categoryException ex) {
      //  return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
       // }
       // return new ResponseEntity<>( categoryService.CreateCategory(categoryDTO), HttpStatus.CREATED);
    }

    // get category by id
    @GetMapping("/{id}")
    public CategoryDTO getByIdCategory(@PathVariable Long id){
        return categoryService.getByIdCategory(id);
    }

// DELETE category by id
    @DeleteMapping("/{id}")
public String categoryDeleteById(@PathVariable Long id){
     return categoryService.categoryDeleteById(id);

    }


}
