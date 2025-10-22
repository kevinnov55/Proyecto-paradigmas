package co.edu.poli.espacio.servicios;

import co.edu.poli.espacio.model.Producto;

/**
 * Implementación de la interfaz {@link OperacionCrud} que gestiona los productos
 * mediante un arreglo fijo. Usa el ID del producto como cadena de texto.
 * 
 * @author Kevin
 * @author Nicolás
 * @version 1.0
 * @since 2025-10-21
 */
public class ImplOperacionCrud implements OperacionCrud {

    private Producto[] productos;

    /**
     * Constructor que inicializa el arreglo con capacidad para 100 productos.
     */
    public ImplOperacionCrud() {
        productos = new Producto[100];
    }

    public String create(Producto b) {
        for (Producto p : productos) {
            if (p != null && String.valueOf(p.getId()).equals(String.valueOf(b.getId()))) {
                return "Ya existe un producto con el ID " + b.getId();
            }
        }
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = b;
                return "Producto creado correctamente: " + b.getNombre();
            }
        }
        return "No hay espacio disponible para registrar más productos.";
    }

    public Producto[] readAll() {
        return productos;
    }

    public Producto readId(String serial) {
        for (Producto p : productos) {
            if (p != null && String.valueOf(p.getId()).equals(serial)) {
                return p;
            }
        }
        return null;
    }

    public String update(String serial, Producto b) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && String.valueOf(productos[i].getId()).equals(serial)) {
                productos[i] = b;
                return "Producto con ID " + serial + " actualizado correctamente.";
            }
        }
        return "No se encontró un producto con el ID " + serial;
    }

    public Producto delete(String serial) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && String.valueOf(productos[i].getId()).equals(serial)) {
                Producto eliminado = productos[i];
                productos[i] = null;
                return eliminado;
            }
        }
        return null;
    }

    /**
     * Obtiene el arreglo de productos para serialización.
     * 
     * @return Arreglo de productos (puede contener nulls).
     */
    public Producto[] getProductos() {
        return productos; // devuelve el arreglo interno (puede contener nulls)
    }

    /**
     * Establece el arreglo de productos desde deserialización.
     * 
     * @param productos Arreglo de productos cargados.
     */
    public void setProductos(Producto[] productos) {
        if (productos != null) {
            this.productos = productos;
        }
    }
}
