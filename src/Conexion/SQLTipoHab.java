package Conexion;


import CRUD.TipoHabitacion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLTipoHab extends SQL{
    ResultSet rs1;

    public void buscarTipo(TipoHabitacion tipoHabitacion) throws SQLException{
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

    //TODO: Refactor con clase Diseño.ListaHabitaciones
    public String[] busquedaTipos() throws SQLException {
        int i = 0;
        String[] tipos;
        connection = getConnection();
        ps = connection.prepareStatement("SELECT DISTINCT(NOMBRE_TIPO) FROM TIPO_HAB");
        rs = ps.executeQuery();

        ps = connection.prepareStatement("SELECT COUNT(DISTINCT(NOMBRE_TIPO)) AS N FROM TIPO_HAB");
        rs1 = ps.executeQuery();
        connection.close();
        rs1.next();
        tipos = new String[rs1.getInt("N") + 1];

        tipos[0] = "Seleccione un tipo";
        i++;
        while (rs.next()) {
            tipos[i] = rs.getString("NOMBRE_TIPO");
            i++;
        }
        return tipos;
    }
}
