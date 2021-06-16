package com.app;

import com.auth.Login;
import java.sql.SQLException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws SQLException {
        System.out.println("Selamat Datang di Paperless PKN Sistem");
        Scanner scan = new Scanner(System.in);
        Login login = new Login();
        System.out.println("==========================");
        System.out.println("Masukkan username");
        login.setUsername(scan.nextLine());
        System.out.println("Masukkan Password");
        login.setPassword(scan.next());
        int res = login.doLogin();
        switch (res) {
            case 1 -> System.out.println("You are Admin");
            case 2 -> System.out.println("You are Mahasiswa");
            case 3 -> System.out.println("You are Dosen");
        }
    }
}
