package co.edu.poli.espacio.model;

import java.io.Serializable;

/**
 * Clase que representa un producto dentro del sistema de gestión espacial.
 * Contiene la información básica de cada producto usado en las misiones,
 * incluyendo su proveedor y estado actual.
 * 
 * Esta clase forma parte del modelo principal del sistema e implementa
 * Serializable para permitir la persistencia de datos.
 * 
 * @author Kevin Ovalle
 * @author Nicolás Fajardo
 * @version 1.4
 * @since 2025-10-21
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String proveedor;
    private String estado;

    /**
     * Constructor vacío.
     */
    public Producto() {}

    /**
     * Constructor que inicializa todos los atributos del producto.
     * 
     * @param id          Identificador único del producto.
     * @param nombre      Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param cantidad    Cantidad disponible.
     * @param proveedor   Proveedor del producto.
     * @param estado      Estado actual del producto (activo, agotado, en revisión...).
     */
    public Producto(int id, String nombre, String descripcion, int cantidad, String proveedor, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.estado = estado;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * Devuelve una representación en texto del producto.
     */
    @Override
    public String toString() {
        return "Producto [ID=" + id +
                ", Nombre=" + nombre +
                ", Descripción=" + descripcion +
                ", Cantidad=" + cantidad +
                ", Proveedor=" + proveedor +
                ", Estado=" + estado + "]";
    }
}
