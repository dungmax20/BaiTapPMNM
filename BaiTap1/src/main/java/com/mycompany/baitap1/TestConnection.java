package com.mycompany.baitap1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestConnection {
  
    public static void main(String[]args) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=QLSanPham;";
            Connection con=DriverManager.getConnection(url,"sa","123");
            System.out.println("Ket noi thanh cong");
            Statement statement;
            statement = con.createStatement();
            String sql="Select masp,tensp,nhasanxuat,maloaisp from sanpham";
            ResultSet rs = statement.executeQuery(sql);
  
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String nhasanxuat = rs.getString("nhasanxuat");
                String maloaisp=rs.getString("maloaisp");
                System.out.println("masp:" + masp);
                System.out.println("tensp:" + tensp);
                System.out.println("nhasanxuat:" + nhasanxuat);
                System.out.println("maloaisp:" + maloaisp);
            }
            String sql2="Select maloaisp,tenloaisp from loaisanpham";
            ResultSet rs2 = statement.executeQuery(sql2);
  
            while (rs2.next()) {
          
                String maloaisp=rs2.getString("maloaisp");
                String tenloaisp=rs2.getString("tenloaisp");
                System.out.println("--------------------");
                System.out.println("tenloaisp"+tenloaisp);
                System.out.println("maloaisp:" + maloaisp);
            }
        
        }
        catch(Exception e){
             e.printStackTrace();
        }
    }
        
        
    }
      


