package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class GetRoles {
    private Arrays roles;

    public void getRoles() throws SQLException {
        String query = "SELECT * FROM Roles ORDER BY RoleId ASC";
        ConnectDB connectDb = new ConnectDB();
        connectDb.setCon();
        Statement sql =  connectDb.getStm();
        ResultSet rs =  sql.executeQuery(query);
        while (rs.next())
        {
            int rol_id = rs.getInt("RoleId");
            String numPoints = rs.getString("Label");
            // print the results
            System.out.format("{'roleId':%s, 'label':%s},\n", rol_id,numPoints);
        }
        sql.close();
    }

    public void setRoles(Arrays roles) {
        this.roles = roles;
    }
}

class Roles {
    
}
