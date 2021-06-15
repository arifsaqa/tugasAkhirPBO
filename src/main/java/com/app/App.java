package com.app;

import com.db.ConnectDB;
import com.db.GetRoles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException {
//        ConnectDB connectDb = new ConnectDB();
//        connectDb.setCon();
//        Statement sql =  connectDb.getStm();
//        sql.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
//                +"VALUES ('Frod', 'Finstone', true, 144000)");
//        sql.close();

        GetRoles roles = new GetRoles();
        roles.getRoles();
    }
}
