package com.example.user;

import java.sql.*;

public class Info {
    public static void main(String[] args) {
        Connection con;
        //jdbc驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //这里我的数据库是department
        String url = "jdbc:mysql://localhost:3306/department";
        String user = "root";
        String password = "000000";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
                String sql;
                //sql语句
                sql="select * from people";

                Statement statement=con.createStatement();
                ResultSet res=statement.executeQuery(sql);

                while (res.next()){
                    String id=res.getString("id");
                    String name=res.getString("name");
                    System.out.println("id:"+id+"\n"+"name:"+name);
                }
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
