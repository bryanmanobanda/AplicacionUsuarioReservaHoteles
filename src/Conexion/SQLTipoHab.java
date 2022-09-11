package Conexion;


import CRUD.TipoHabitacion;

import java.sql.SQLException;
import java.util.ArrayList;

public class SQLTipoHab extends SQL {

    public void buscarTipo(TipoHabitacion tipoHabitacion) throws SQLException {
        connection = getConnection();

        ps = connection.prepareStatement("SELECT * FROM TIPO_HAB WHERE NOMBRE_TIPO = ?");
        ps.setString(1, tipoHabitacion.getNombreTipo());
        rs = ps.executeQuery();
        connection.close();

        if (rs.next()) {
            tipoHabitacion.setNumBanios(rs.getInt("NUMBANIOS"));
            tipoHabitacion.setCapacidad(rs.getInt("CAPACIDAD"));
        }
    }

    public ArrayList<String> listarNombreTipos() throws SQLException {
        ArrayList<String> tipos = new ArrayList<>();
        connection = getConnection();
        ps = connection.prepareStatement("SELECT NOMBRE_TIPO FROM TIPO_HAB");
        rs = ps.executeQuery();
        connection.close();
        while (rs.next()) {
            tipos.add(rs.getString("NOMBRE_TIPO"));
        }
        return tipos;
    }
}
