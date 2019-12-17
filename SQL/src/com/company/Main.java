package com.company;


import com.company.Modules.SQL;

import java.sql.*;

public class Main {

    SQL sql = new SQL("northwind","root","");

    public static void main(String[] args) {

        Main main = new Main();

        try {
            main.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void init()  throws SQLException{
        ResultSet res = sql.open("SELECT * FROM categories;");

        while (res.next()){
            System.out.println(res.getString(2));
        }
    }
}
