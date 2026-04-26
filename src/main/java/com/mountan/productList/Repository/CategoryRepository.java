package com.mountan.productList.Repository;

import com.mountan.productList.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String categoryName);
}
