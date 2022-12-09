package ru.starstreet.HM4.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.starstreet.HM4.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class ProductRepository {
    private long lastIndex;

    private Map<Long, Product> map;

    @PostConstruct
    private void init() {
        lastIndex = -1;
        map = new HashMap<>();
        Random rnd = new Random();
        for (int i = 0; i <= 4; i++) {
            add(new Product("product #" + i, rnd.nextInt(500)));
        }

    }

    public void add(Product product) {
        product.setId(++lastIndex);
        map.put(lastIndex, product);
    }

    public void deleteById(long id) {
        map.remove(id);
    }

    public List<Product> getProductList() {
        return map.keySet().stream()
                .sorted()
                .map(m -> map.get(m))
                .toList();
    }

    public Product getProductById(Long id) {
        return map.get(id);
    }
}
