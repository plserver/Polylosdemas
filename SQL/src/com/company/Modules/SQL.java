package com.company.Modules;

import java.sql.*;

public class SQL {

    private String db;
    private String user;
    private String password;

    public SQL(String db, String user, String password) {
        this.db = db;
        this.user = user;
        this.password = password;
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
    }

    public ResultSet open(String query, Object[] values) throws SQLException {
        Connection conect = connection();
        PreparedStatement ps = conect.prepareStatement(query);

        for (int i = 0; i < values.length; i++){
            ps.setObject(i+1,values[i]);
        }

        return ps.executeQuery();
    }

    public ResultSet open(String query) throws SQLException {
        Connection conect = connection();
        Statement ps = conect.createStatement();

        return ps.executeQuery(query);
    }

    public boolean modify(String query, Object[] values) throws SQLException {

        Connection conect = connection();
        PreparedStatement ps = conect.prepareStatement(query);

        for (int i = 0; i < values.length; i++) {
            ps.setObject(i + 1, values[i]);
        }

        if(ps.executeUpdate() == -1){
            return false;
        }

        return true;
    }

    public boolean modify(String query) throws SQLException {
        Connection conect = connection();
        Statement ps = conect.createStatement();

        if(ps.executeUpdate(query) == -1){
            return false;
        }
        return true;
    }

    public void close(ResultSet res) throws SQLException {
        res.close();
    }

}