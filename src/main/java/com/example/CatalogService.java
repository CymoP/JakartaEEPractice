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

    // @Transactional
    // public void addProduct(Product product) {
    //     repository.save(product);
    // }
}