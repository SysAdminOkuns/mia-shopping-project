package com.mia.DaOinterface;

import java.sql.*;

public class ConnectionDAO {

    static Connection con = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public static Connection getConnection() throws SQLException {
        final String DBURL = "jdbc:mysql://localhost:3306/shopping";
        final String DBUSERNAME = "student";
        final String DBPASSWORD = "pass123!";

        con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
        System.out.println("Connected Database Successfully");

        return con;
    }

    public void disconnect()
    {
        try {
            if(rs != null)
            {
                rs.close();
            }
            if(ps != null)
            {
                ps.close();
            }
            if(con != null)
            {
                con.close();
            }
        }catch (Exception e) {
// TODO: handle exception
        }
    }

//    public static void main(String[] args) throws SQLException {
//        ConnectionDAO.getConnection();
//    }
}
