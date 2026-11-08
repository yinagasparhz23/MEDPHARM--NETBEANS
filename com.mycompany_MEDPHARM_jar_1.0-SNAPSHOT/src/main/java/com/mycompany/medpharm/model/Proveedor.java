package com.mycompany.medpharm.model;

public class Proveedor {
    
    private int idProveedor;
    private String nombreEmpresa;
    private String contacto;
    private String direccion;
    private String telefono;
    private String correo;

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor con todos los campos
    public Proveedor(int idProveedor, String nombreEmpresa, String contacto, String direccion, String telefono, String correo) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y Setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}