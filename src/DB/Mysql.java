/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author 3RO
 */
public class Mysql {
    private static String pass="";
    private static String user="root";
    //private static String pass="Sebas2804.";
    private static String url="jdbc:mysql://localhost:3306/biblioteca";
    private static Connection Conn;
    
    public static Connection getConnection(){
        try{
            Conn=DriverManager.getConnection(url, user, pass);
            if(Conn!=null){
                //JOptionPane.showMessageDialog(null, "Conexión estalecida con éxito");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        return Conn;
    }
    
    public static void main(String[] args) {
    Connection con = Mysql.getConnection();
    if (con != null) {
        System.out.println("Conexión establecida con éxito");
    } else {
        System.err.println("Error al conectar con la base de datos");
    }
}

    
 

}