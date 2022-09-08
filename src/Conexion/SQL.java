package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class SQL extends ConexionBaseDatos{
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected Connection connection;
}
