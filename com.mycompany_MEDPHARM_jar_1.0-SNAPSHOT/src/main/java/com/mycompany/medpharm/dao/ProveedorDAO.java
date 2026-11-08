package com.mycompany.medpharm.dao;

public class ProveedorDAO {
    
    private int idProveedor;
    private String nombreEmpresa;
    private String contacto;
    private String telefono;
    private String direccion;
    private String correo;
    
    public ProveedorDAO() {
    }

    public ProveedorDAO(int idProveedor, String nombreEmpresa, String contacto, String telefono, String direccion, String correo) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}