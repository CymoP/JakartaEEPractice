package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CatalogService {

    @Inject
    private CatalogRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProduct(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void addProduct(Product product) {
        repository.save(product);
    }

    @Transactional
    public void removeProduct(Long id) {
        repository.removeById(id);
    }
}