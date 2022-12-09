package ru.starstreet.HM4.service;

import org.springframework.stereotype.Service;
import ru.starstreet.HM4.model.Product;
import ru.starstreet.HM4.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


    public void add(String name, Integer price) {
        productRepository.add(new Product(name, price));
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public void changePriceById(Long productId, Integer delta) {
        Product product = productRepository.getProductById(productId);
        product.setPrice(product.getPrice() + delta);
    }
}
