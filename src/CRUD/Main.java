package CRUD;

import Interfaces.PaginaPrincipal;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
      PaginaPrincipal pagina = new PaginaPrincipal();
      pagina.setVisible(true);
    }
}