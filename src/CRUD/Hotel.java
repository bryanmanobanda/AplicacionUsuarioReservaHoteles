package CRUD;

import javax.swing.*;
import java.util.Objects;

public class Hotel {
    private int idHotel;
    private String nombre;
    private String continente;
    private String descripcion;
    private int prestigio;
    private String correo;
    private String telefono;
    private String pais;
    private String ciudad;
    private Icon icono;

    public Icon getIcono() {
        return icono;
    }

    private void setIcono() {
        switch (prestigio) {
            case 1:
                icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Hotel/1Hotel.png"))));
                break;
            case 2:
                icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Hotel/2Hotel.png"))));
                break;
            case 3:
                icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Hotel/3Hotel.png"))));
                break;
            case 4:
                icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Hotel/4Hotel.png"))));
                break;
            case 5:
                icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Hotel/5Hotel.png"))));
                break;
        }
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrestigio(int prestigio) {
        this.prestigio = prestigio;
        this.setIcono();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}