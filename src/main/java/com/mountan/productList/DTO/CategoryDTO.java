package com.mountan.productList.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;

    public void getProducts(List<ProductDTO> list) {

    }
}
