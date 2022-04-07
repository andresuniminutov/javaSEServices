/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaGradle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class DatabaseAction {

    public Connection getConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/db_bancox";
        String username = "root";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
                return conn;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void getData() {
        try {
            String sql = "SELECT * FROM tb_services";

            Statement statement = getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                String id = result.getString("ser_id");
                String name = result.getString("ser_name");
                String description = result.getString("ser_description");
                String image = result.getString("ser_image");

                // String output = "Servicio %s - %s - %s - %s";
                String output = "Servicio %s - %s - %s - %s";
                
                System.out.println(String.format(output, id, name, description, image));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeData() {

    }

}
