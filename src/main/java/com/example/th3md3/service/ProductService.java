package com.example.th3md3.service;

import com.example.th3md3.dao.ProductRepo;
import com.example.th3md3.model.Product;

import java.util.ArrayList;

public class ProductService {
    ProductRepo productRepo = new ProductRepo();
    public void creatProduct(Product product,int id){
        productRepo.creatProduct(product,id);
    }

    public ArrayList<Product> findAll() {
        return productRepo.findAll();
    }
    public void deleteProduct(int id){
        productRepo.deleteProduct(id);
    }
    public Product findById(int id){
        return productRepo.findById(id);
    }

    public ArrayList<Product> searchProduct(String search) {
       return productRepo.searchProduct(search);
    }

    public void updateProduct(Product product,int id) {
        productRepo.updateProduct(product,id);
    }
}
