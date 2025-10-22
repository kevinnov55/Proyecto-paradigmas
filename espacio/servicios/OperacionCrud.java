package co.edu.poli.espacio.servicios;

import co.edu.poli.espacio.model.Producto;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre objetos de tipo Producto, usando el identificador como cadena de texto.
 * 
 * @author Kevin Ovalle
 * @author Nicolás Fajardo
 * @version 1.0
 * @since 2025-10-21
 */
public interface OperacionCrud {

    /**
     * Crea un nuevo producto en el sistema.
     * 
     * @param b Producto a registrar.
     * @return Mensaje indicando el resultado de la operación.
     */
    String create(Producto b);

    /**
     * Retorna todos los productos registrados.
     * 
     * @return Arreglo con todos los productos.
     */
    Producto[] readAll();

    /**
     * Busca un producto por su identificador.
     * 
     * @param serial Identificador único del producto.
     * @return El producto encontrado o null si no existe.
     */
    Producto readId(String serial);

    /**
     * Actualiza los datos de un producto según su identificador.
     * 
     * @param serial Identificador único del producto.
     * @param b      Producto con la información actualizada.
     * @return Mensaje indicando el resultado.
     */
    String update(String serial, Producto b);

    /**
     * Elimina un producto según su identificador.
     * 
     * @param serial Identificador del producto a eliminar.
     * @return El producto eliminado o null si no se encuentra.
     */
    Producto delete(String serial);
}
