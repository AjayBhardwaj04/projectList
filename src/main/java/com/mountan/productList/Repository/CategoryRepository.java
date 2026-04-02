package com.mountan.productList.Repository;

import com.mountan.productList.Entity.category;
import com.mountan.productList.Entity.product;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface categoriesRepository extends JpaRepository<category,Long> {
}
