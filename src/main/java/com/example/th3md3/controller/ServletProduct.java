package com.example.th3md3.controller;

import com.example.th3md3.model.Category;
import com.example.th3md3.model.Product;
import com.example.th3md3.service.CategoryService;
import com.example.th3md3.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletProduct", value = "/product")
public class ServletProduct extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "creat":
                getCategory(request,response);
                break;
            case "display":
                displayProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "creat":
                creatProduct(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
        }
    }
    public void getCategory(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            request.setAttribute("categories",categoryService.findAll());
            request.getRequestDispatcher("creat.jsp").forward(request,response);
    }
    public void creatProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,quantity,color,description);
        productService.creatProduct(product,id_category);
        response.sendRedirect("/product?action=display");
    }
    public void displayProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);
    }
    public void deleteProduct(HttpServletRequest request ,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("/product?action=display");
    }
    public void editProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("p",productService.findById(id));
        request.setAttribute("categories",categoryService.findAll());
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
    public void updateProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int id_category = Integer.parseInt(request.getParameter("category"));
            Product product = new Product(id,name,price,quantity,color,description,categoryService.findById(id_category));
            productService.updateProduct(product,id);
            response.sendRedirect("/product?action=display");
    }
    public void searchProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String search = "%" + request.getParameter("search")+"%";
        ArrayList<Product> products = productService.searchProduct(search);
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);
    }
}
