package ru.starstreet.HM4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.starstreet.HM4.model.Product;
import ru.starstreet.HM4.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProductList() {
        return productService.getProductList();
    }
    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
    @GetMapping("/products/changePrice")
    public void changePrice(Long productId, Integer delta){
        productService.changePriceById(productId, delta);
    }
    @PostMapping("/products/add")
    public void addProduct(@RequestBody Product product){
        productService.add(product);
    }


}
