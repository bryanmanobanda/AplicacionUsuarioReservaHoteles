package CRUD;

import java.util.ArrayList;

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
  private ArrayList<Habitacion> habitaciones;
  private ArrayList<Administrador> administradores;

  public Hotel() {
    this.idHotel = 0;
    this.nombre = "";
    this.continente = "";
    this.descripcion = "";
    this.prestigio = 0;
    this.correo = "";
    this.telefono = "";
    this.pais = "";
    this.ciudad = "";
  }
  
  
  public Hotel(int idHotel, String nombre, String continente, String descripcion, int prestigio, String correo, String telefono, String pais, String ciudad) {
    this.idHotel = idHotel;
    this.nombre = nombre;
    this.continente = continente;
    this.descripcion = descripcion;
    this.prestigio = prestigio;
    this.correo = correo;
    this.telefono = telefono;
    this.pais = pais;
    this.ciudad = ciudad;
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

  public int getPrestigio() {
    return prestigio;
  }

  public void setPrestigio(int prestigio) {
    this.prestigio = prestigio;
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

  public ArrayList<Habitacion> getHabitaciones() {
    return habitaciones;
  }

  public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
    this.habitaciones = habitaciones;
  }

  public ArrayList<Administrador> getAdministradores() {
    return administradores;
  }

  public void setAdministradores(ArrayList<Administrador> administradores) {
    this.administradores = administradores;
  }

  @Override
  public String toString() {
    return "Hotel{" + "idHotel=" + idHotel + ", nombre=" + nombre + ", continente=" + continente + ", descripcion=" + descripcion + ", prestigio=" + prestigio + ", correo=" + correo + ", telefono=" + telefono + ", pais=" + pais + ", ciudad=" + ciudad + ", habitaciones=" + habitaciones + ", administradores=" + administradores + '}';
  }
  
  
}