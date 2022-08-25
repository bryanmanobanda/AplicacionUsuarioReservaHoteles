package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
  public static final String URL = "jdbc:postgresql://localhost:5432/RESERVA_HOTEL";
  public Connection getConnection() throws ClassNotFoundException, SQLException{
    Connection connection = null;
    connection = DriverManager.getConnection(URL,"Administrador_Hotel","admin");
    return connection;
  }
}