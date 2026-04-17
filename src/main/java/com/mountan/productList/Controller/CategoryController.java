package com.mountan.productList.Controller;

import com.mountan.productList.DTO.CategoryDTO;
import com.mountan.productList.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private  CategoryService categoryService;



    @PostMapping
    public ResponseEntity< CategoryDTO> createCategory( @Validated @RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>( categoryService.CreateCategory(categoryDTO), HttpStatus.CREATED);
    }

}
