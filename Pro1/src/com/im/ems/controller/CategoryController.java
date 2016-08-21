/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.im.ems.controller;

import com.im.ems.model.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Danushka
 */
public class CategoryController {

    public static boolean create(Category category) {

        try {
            String sql = "INSERT INTO  category (name) VALUES ('" + category.getName() + "')";
            String username = "root";
            String password = "123";
            String url = "jdbc:mysql://localhost:3306/dbems";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, username, password);

            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            //JOptionPane.showMessageDialog(this, "Saved");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Category retrieve(int id){
    
        Category category = new Category();
        try {
            
            String sql = "SELECT * FROM category WHERE cid='"+id+"'";
            String username = "root";
            String password = "123";
            String url = "jdbc:mysql://localhost:3306/dbems";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, username, password);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
               String name = rs.getString("name");
               category.setName(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
