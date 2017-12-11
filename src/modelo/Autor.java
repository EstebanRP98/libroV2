/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Joel Vasquez
 */
public class Autor {
    
    private String Nombre;
    private String Apellido;
    private String fechaNac;
    private String Cedula;

    public Autor(String Nombre, String Apellido, String fechaNac, String Cedula) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.fechaNac = fechaNac;
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    @Override
    public String toString() {
        return "Autor{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", fechaNac=" + fechaNac + ", Cedula=" + Cedula + '}';
    }
    
    
    
    
}
