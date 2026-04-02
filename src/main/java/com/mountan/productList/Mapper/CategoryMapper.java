package com.mountan.productList.Mapper;

import com.mountan.productList.DTO.categoriesDTO;
import com.mountan.productList.Entity.category;
import jdk.jfr.Category;

import java.util.Locale;

public class categoriesMapper {
    public static category toCategoryEntity(categoriesDTO categoriesDTO) {
        category category = new category();
        category.getName(categoriesDTO.getName());

    }
}
