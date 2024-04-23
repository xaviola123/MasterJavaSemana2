package bibilioteca_jdbc_BBDD.Conexion;
import java.sql.*;
public class Conection {
    String url = "jdbc:mysql://localhost:3306/biblioteca";
    String user = "root";
    String pass = "root";

    public Connection conexion;

    {
        try {
            conexion = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
