/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fikri Khairul Shaleh
 */
public class Koneksi {
    public Connection con;
    public Statement stat;
    
    private static final String DATABASE_NAME = "lelang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
   
    public Koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/"+DATABASE_NAME,USERNAME,PASSWORD);
            stat = con.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
}
