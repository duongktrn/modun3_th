package com.example.th3md3.service;

import com.example.th3md3.dao.CategoryRepo;
import com.example.th3md3.model.Category;

import java.util.ArrayList;

public class CategoryService {
    CategoryRepo categoryRepo = new CategoryRepo();
    public ArrayList<Category> findAll(){
       return categoryRepo.findAll();
    }
    public Category findById(int id){
        return categoryRepo.findById(id);
    }
}
