package com.mountan.productList.Repository;

import com.mountan.productList.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
