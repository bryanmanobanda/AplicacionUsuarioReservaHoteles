package CRUD;

import java.sql.Date;

public class Cliente {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;
    private String pais;
    private Date fechaNacimiento;

    public Cliente(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Cliente(String nombre, String correo, String contrasenia, String pais, Date fechaNacimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean validarContrasenia(String contrasenia) {
        return this.contrasenia.equals(contrasenia);
    }
}
