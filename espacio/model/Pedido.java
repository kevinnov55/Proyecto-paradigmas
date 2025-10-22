package co.edu.poli.espacio.model;

import java.time.LocalDate;

/**
 * Clase que representa un pedido dentro del sistema de productos espaciales.
 * Cada pedido contiene información sobre el producto solicitado, la cantidad
 * requerida, la fecha de registro, el proveedor y el estado del pedido.
 * 
 * Esta clase puede interactuar con {@link Producto} y {@link EquipoEspacial}
 * para simular las órdenes logísticas de la misión espacial.
 * 
 * @author Kevin Ovalle
 * @author Nicolás Fajardo
 * @version 1.1
 * @since 2025-10-21
 */
public class Pedido {

    private int idPedido;
    private Producto producto;
    private int cantidadSolicitada;
    private LocalDate fechaPedido;
    private String proveedor;
    private String estado;

    /**
     * Constructor vacío.
     */
    public Pedido() {
        this.fechaPedido = LocalDate.now();
        this.estado = "Pendiente";
    }

    /**
     * Constructor con parámetros.
     * 
     * @param idPedido           Identificador único del pedido.
     * @param producto           Producto asociado al pedido.
     * @param cantidadSolicitada Cantidad solicitada del producto.
     * @param proveedor          Nombre del proveedor del pedido.
     * @param estado             Estado actual del pedido (Pendiente, Enviado, Entregado...).
     */
    public Pedido(int idPedido, Producto producto, int cantidadSolicitada, String proveedor, String estado) {
        this.idPedido = idPedido;
        this.producto = producto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.proveedor = proveedor;
        this.estado = estado;
        this.fechaPedido = LocalDate.now();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Calcula el total de unidades restantes en el inventario
     * después de realizar el pedido.
     * 
     * @return Cantidad restante (puede ser negativa si excede el stock).
     */
    public int calcularRestante() {
        return producto.getCantidad() - cantidadSolicitada;
    }

    /**
     * Representación textual del pedido.
     * 
     * @return Cadena con los detalles del pedido.
     */
    @Override
    public String toString() {
        return "Pedido ID: " + idPedido +
               "\nProducto: " + producto.getNombre() +
               "\nCantidad solicitada: " + cantidadSolicitada +
               "\nProveedor: " + proveedor +
               "\nEstado: " + estado +
               "\nFecha: " + fechaPedido +
               "\nStock restante: " + calcularRestante() + "\n";
    }
}
