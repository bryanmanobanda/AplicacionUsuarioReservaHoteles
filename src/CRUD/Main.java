package CRUD;

import Interfaces.PaginaPrincipal;

public class Main {
    public static void main(String[] args) {
        //TODO Cambiar disponibilidad al eliminar reserva
        PaginaPrincipal pagina;
        try {
            pagina = new PaginaPrincipal();
            pagina.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}