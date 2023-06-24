package com.ust.SpringReactive.Mongo.utils;


import com.ust.SpringReactive.Mongo.dto.ProductDto;
import com.ust.SpringReactive.Mongo.entity.Product;
import org.springframework.beans.BeanUtils;
public class AppUtils {
    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
