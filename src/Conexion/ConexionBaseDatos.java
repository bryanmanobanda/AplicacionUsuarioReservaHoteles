package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
  private static final String URL = "jdbc:postgresql://localhost:5432/RESERVA_HOTEL";

  public static Connection getConnection() throws SQLException{
    return DriverManager.getConnection(URL,"Administrador_Hotel","admin");
  }
}