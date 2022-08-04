package com.example.th3md3.dao;

import com.example.th3md3.connection.Myconnection;
import com.example.th3md3.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryRepo {
    private final String SELECT_CATEGORY_BY_ID = "select name from category where id=?";
    private final String SELECT_ALL_CATEGORY = "select * from category";
    private final Myconnection myconnection = new Myconnection();
    public ArrayList<Category> findAll(){
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return categories;
    }
    public Category findById(int id){
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_category = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Category(id_category,name);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
        return null;
    }
}
