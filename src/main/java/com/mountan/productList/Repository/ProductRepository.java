package com.mountan.productList.Repository;

import com.mountan.productList.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


        boolean existsByNameAndPriceAndDescriptionAndCategoryId(
                String name,
                BigDecimal price,
                String description,
                Long categoryId
        );
    }

