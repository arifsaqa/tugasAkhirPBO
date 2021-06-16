package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {
    private static Connection con;
    private  Statement stm;
    private String dbName = "PBO";

    public  void setCon(){
        try {
            String url = "jdbc:mysql://localhost/"+dbName+"?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        } catch (Exception err) {
            System.out.println("Database connection is failed");
            System.out.println("Set the DB name First(at com.db.ConnectDB) and make sure to run your server");
//            System.out.println(err);
            this.stm = null;
        }
    }
    public Statement getStm (){
        return this.stm;
    }
}
