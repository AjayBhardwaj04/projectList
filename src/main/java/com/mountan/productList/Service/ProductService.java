package com.mountan.productList.Service;

import com.mountan.productList.DTO.ProductDTO;
import com.mountan.productList.Entity.Category;
import com.mountan.productList.Entity.Product;
import com.mountan.productList.Mapper.ProductMapper;
import com.mountan.productList.Repository.CategoryRepository;
import com.mountan.productList.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    //GET ALL PRODUCTS
    public List<ProductDTO> getAllProduct ( ){
      return productRepository.findAll().stream().map(ProductMapper ::toProductDTO).toList();
    }

    //GET PRODUCT BY IDs
    public ProductDTO getProductById( Long id){
       Product product = productRepository.findById(id).orElseThrow(
               () -> new RuntimeException("PRODUCT ID NOT FOUNDS"));
         return ProductMapper.toProductDTO(product);
    }

    // Update Products
    public ProductDTO updateProduct( Long id, ProductDTO productDTO){
       Product product = productRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("PRODUCT NOT FIND"));
       Category category = categoryRepository.findById(productDTO.getCategoryID()).orElseThrow(
               ()-> new RuntimeException("CATEGORY NOT FOUND"));

       product.setName(productDTO.getName());
       product.setDescription(productDTO.getDescription());
       product.setPrice(productDTO.getPrice());
       product.setCategory(category);
       productRepository.save(product);
       return  ProductMapper.toProductDTO(product);
    }

    //DELETE PRODUCT
    public  String deleteProduct( Long id){
        productRepository.deleteById(id);
        return "Product ID "+ id + " has been DELETED";
    }



}
