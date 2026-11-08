package com.mycompany.medpharm;
import Util.ConexionBD;

import com.mycompany.medpharm.controller.*;

public class MEDPHARM {
    
    // Todos los controladores del sistema
    public static ProductoController productoController;
    public static UsuarioController usuarioController;
    public static ClienteController clienteController;
    public static ProveedorController proveedorController;
    public static VentaController ventaController;
    public static CompraController compraController;
    public static InventarioController inventarioController;
    
    // Constructor: inicializa todos los controladores
    public MEDPHARM() {
        productoController = new ProductoController();
        usuarioController = new UsuarioController();
        clienteController = new ClienteController();
        proveedorController = new ProveedorController();
        ventaController = new VentaController();
        compraController = new CompraController();
        inventarioController = new InventarioController();
    }
    
    // Método para iniciar el sistema
    public void iniciar() {
        System.out.println("======================================");
        System.out.println("   🏪 Sistema de Farmacia MEDPHARM    ");
        System.out.println("======================================");
        Util.ConexionBD.conectar();
        System.out.println("✅ Sistema iniciado correctamente");
        System.out.println("📦 Controladores cargados: 7");
        System.out.println("======================================");
    }
    
    public static void main(String[] args) {
        MEDPHARM sistema = new MEDPHARM();
        sistema.iniciar();
    }
}
