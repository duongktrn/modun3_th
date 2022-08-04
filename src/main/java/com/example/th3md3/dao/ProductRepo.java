package com.example.th3md3.dao;

import com.example.th3md3.connection.Myconnection;
import com.example.th3md3.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepo {
    private final Myconnection myconnection = new Myconnection();
    private final CategoryRepo categoryRepo = new CategoryRepo();
    private final String SELECT_ALL_PRODUCT = "SELECT * FROM PRODUCT";
    private final String INSERT_PRODUCT = "insert into product(name,price,quantity,color,description,id_category) VALUE(?,?,?,?,?,?)";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE ID=?";
    private final String UPDATE_PRODUCT = "UPDATE PRODUCT SET NAME=?,PRICE=?,QUANTITY=?,DESCRIPTION=?,CATEGORY_ID=? WHERE ID=?";
    private final String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCT WHERE ID=?";
    public void creatProduct(Product product,int id_category){
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,id_category);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteProduct(int id){
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String color = resultSet.getString("color");
                int id_category = resultSet.getInt("id_category");
                Product product = new Product(id,name,price,quantity,color,description,categoryRepo.findById(id_category));
                products.add(product);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    public Product findById(int id){
        try {
            Connection connection = myconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String color = resultSet.getString("color");
                int id_category = resultSet.getInt("id_category");
                Product product = new Product(id,name,price,quantity,color,description,categoryRepo.findById(id_category));
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
