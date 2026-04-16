package com.mountan.productList.Service;

import com.mountan.productList.DTO.ProductDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Entity.Product;
import com.mountan.productList.Mapper.ProductMapper;
import com.mountan.productList.Repository.CategoryRepository;
import com.mountan.productList.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductDTO createProduct(ProductDTO productDTO){
        // name, price, description ,categoryID



       Category category = categoryRepository.findById(productDTO.getCategoryID()).orElseThrow(()
                ->new RuntimeException("Category Not find"));
       //
         //DTO ->> entity chang (Dto can be not save in database) convert
        Product product =  ProductMapper.toProductEntity(productDTO,category);
         product = productRepository.save(product);

         //entity  to dto
         return ProductMapper.toProductDTO(product);
    }

}
