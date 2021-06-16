package com.auth;

import com.db.ConnectDB;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    private String username;
    private String password;
    private int userId = 0;
    private static StandardPBEStringEncryptor encryptor;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private  String Encrypting(String a){
        encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("ABXY");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        return encryptor.encrypt(a);
    }

    private  String Decrypting(String a){
        encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("ABXY");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        return encryptor.decrypt(a);
    }

    public int doLogin() throws SQLException {
        String query = "SELECT * FROM Users ORDER BY userId ASC";
        ConnectDB connectDb = new ConnectDB();
        connectDb.setCon();
        Statement sql =  connectDb.getStm();
        ResultSet rs =  sql.executeQuery(query);
        while (rs.next()){
            String usernameData = rs.getString("username");
            String passwordData = rs.getString("password");
            int user_id = rs.getInt("userId");
            boolean isPasswordValid = Decrypting(passwordData).equals(getPassword());
            boolean isUsernameValid = usernameData.equals(getUsername());
            if (isPasswordValid && isUsernameValid){
                setUserId(user_id);
            }
        }
        sql.close();
        return getUserId();
    }

}


