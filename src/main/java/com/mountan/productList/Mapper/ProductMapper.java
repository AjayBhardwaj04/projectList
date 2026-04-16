package com.mountan.productList.Mapper;

import com.mountan.productList.DTO.ProductDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Entity.Product;

public class ProductMapper {
    //entity to dto
    public static ProductDTO toProductDTO(Product product) {
     return  new ProductDTO(
             product.getName(),
             product.getDescription(),
             product.getPrice(),
             product.getCategory().getId()

     );


    }
    //        DTO to Entity
    public static Product toProductEntity(ProductDTO productDTO, Category  category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
    
}
