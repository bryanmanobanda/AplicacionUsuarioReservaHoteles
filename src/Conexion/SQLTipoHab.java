package Conexion;

import CRUD.Hotel;
import CRUD.TipoHabitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLTipoHab {
    PreparedStatement ps;
    ResultSet rs, rs1;
    Connection connection;

    public void buscarTipo(TipoHabitacion tipoHabitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        connection = con.getConnection();

        ps = connection.prepareStatement("SELECT * FROM TIPO_HAB WHERE NOMBRE_TIPO = ?");
        ps.setString(1, tipoHabitacion.getNombreTipo());
        rs = ps.executeQuery();

        if (rs.next()){
            tipoHabitacion.setNumBanios(rs.getInt("NUMBANIOS"));
            tipoHabitacion.setCapacidad(rs.getInt("CAPACIDAD"));
        }
    }

    public void insertarTipoHab(TipoHabitacion tipoHabitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("insert into TIPO_HAB values(?, ?, ?)");
        ps.setString(1, tipoHabitacion.getNombreTipo());
        ps.setInt(2, tipoHabitacion.getNumBanios());
        ps.setInt(3, tipoHabitacion.getCapacidad());
        ps.executeUpdate();
    }

    public ArrayList<TipoHabitacion> busquedaTiposHab() throws SQLException, ClassNotFoundException {
        ArrayList<TipoHabitacion> listaTipos = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("SELECT * FROM TIPO_HAB");
        rs = ps.executeQuery();
        while (rs.next()) {
            TipoHabitacion tipo = new TipoHabitacion(rs.getString("NOMBRE_TIPO"));
            tipo.setNumBanios(rs.getInt("NUMBANIOS"));
            tipo.setCapacidad(rs.getInt("CAPACIDAD"));
            listaTipos.add(tipo);
        }
        return listaTipos;
    }
    
    public String[] busquedaTipos() throws ClassNotFoundException, SQLException {
      int i = 0;  
      String[] tipos;
      ConexionBaseDatos con = new ConexionBaseDatos();
      Connection connection = con.getConnection();
      ps = connection.prepareStatement("SELECT DISTINCT(NOMBRE_TIPO) FROM TIPO_HAB");
      rs = ps.executeQuery();
      
      ps = connection.prepareStatement("SELECT COUNT(DISTINCT(NOMBRE_TIPO)) AS N FROM TIPO_HAB");
      rs1 = ps.executeQuery();
      
      rs1.next();
      tipos = new String[rs1.getInt("N")+1];
      
      tipos[0] = "Seleccione un tipo";
        i++;
      while (rs.next()) {
        tipos[i] = rs.getString("NOMBRE_TIPO");
        i++;
      }
      return tipos;
    }
}
