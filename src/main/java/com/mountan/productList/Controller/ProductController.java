package com.mountan.productList.Controller;

import com.mountan.productList.DTO.ProductDTO;
import com.mountan.productList.Service.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Product Rest API CURD Operation",
        description = "Create,Update, Read, Delete operation for product REST API "
)
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class ProductController {
    private ProductService productService;

    // GET ALL PRODUCTS
    @GetMapping
    public List<ProductDTO> getProduct(){
        return productService.getAllProduct();
    }

    //GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    // CREATE PRODUCT MAPPING
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping

    public ResponseEntity<ProductDTO> createProducts(@RequestBody ProductDTO productDTO){
       ProductDTO createProduct = productService.createProduct(productDTO);
       return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
    }
// UPDATE PRODUCTS
@PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProducts(@PathVariable Long id ,@RequestBody ProductDTO productDTO){
       return productService.updateProduct(id,productDTO);

    }
    //DELETE PRODUCTS
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        return productService.deleteProduct(id);
    }

}
