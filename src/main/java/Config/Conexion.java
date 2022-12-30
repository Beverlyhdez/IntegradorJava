/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Beverly
 */
public class Conexion 
{
    public String driver="com.mysql.jdbc.Driver";
    
    
    public Connection getConnection()
    {
        Connection conexion=null;
        
        try
        {
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud22547","root","");
        }
        catch(ClassNotFoundException|SQLException e)
        {
            System.out.println(e);
        }     
        return conexion;
    }
    
    public static void main(String[] args) throws SQLException
    {
        Connection conexion=null;
        Conexion con=new Conexion();
        conexion=con.getConnection();
        
        
        PreparedStatement ps;
        ResultSet rs;
        
        ps=conexion.prepareStatement("select * from socios");
        
        rs=ps.executeQuery();
        
        while(rs.next())
        {
            int id=rs.getInt("idSocio");
            String apellido=rs.getString("apellido");
            System.out.println("ID:"+id+" Apellido: "+apellido);
        }
    }
}
