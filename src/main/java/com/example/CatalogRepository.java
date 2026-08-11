package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class CatalogRepository {

    @PersistenceContext(unitName = "catalogPU")
    private EntityManager entityManager;

    public List<Product> findAll() {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public void save(Product product) {
        entityManager.persist(product);
    }
}