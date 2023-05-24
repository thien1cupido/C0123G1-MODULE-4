package com.example.products_management.repository.impl;

import com.example.products_management.model.Product;
import com.example.products_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select p from Product p", Product.class).getResultList();
        return productList;
    }

    @Override
    public boolean saveProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
        return true;
    }


    @Override
    public boolean deleteProductById(Integer id) {
        Product product =findProductById(id);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(product);
        transaction.commit();
        return true;
    }

    @Override
    public Product findProductById(Integer id) {
        Product product=BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public boolean editProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
        return true;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = BaseRepository.entityManager.createQuery("select p from Product p where p.name like :names", Product.class).setParameter("names",name).getResultList();
        return productList;
    }
}
