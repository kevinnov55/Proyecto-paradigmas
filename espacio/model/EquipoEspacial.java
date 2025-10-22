package co.edu.poli.espacio.model;

/**
 * Clase que representa un equipo espacial dentro del sistema.
 * Cada equipo gestiona un conjunto de productos asignados para
 * las misiones espaciales. Permite agregar, eliminar y buscar productos,
 * además de mostrar toda la información del equipo.
 * 
 * Incluye atributos como el peso total del equipo
 * y el tipo de equipo (herramienta, traje, comunicador, etc.).
 * 
 * Esta clase funciona como contenedor del modelo {@link Producto}.
 * 
 * @author Kevin Ovalle
 * @author Nicolás Fajardo
 * @version 1.3
 * @since 2025-10-21
 */
public class EquipoEspacial {

    private String nombreEquipo;
    private String tipoEquipo;
    private double peso;
    private Producto[] productos;

    /**
     * Constructor que inicializa un equipo con nombre, tipo y espacio para productos.
     * 
     * @param nombreEquipo Nombre identificador del equipo.
     * @param tipoEquipo   Tipo del equipo (herramienta, traje, comunicador...).
     * @param peso         Peso total del equipo (en kilogramos).
     */
    public EquipoEspacial(String nombreEquipo, String tipoEquipo, double peso) {
        this.nombreEquipo = nombreEquipo;
        this.tipoEquipo = tipoEquipo;
        this.peso = peso;
        this.productos = new Producto[100];
    }

    /**
     * Agrega un producto al primer espacio disponible del arreglo.
     * 
     * @param p Producto a agregar.
     * @return true si se agregó correctamente, false si no hay espacio disponible.
     */
    public boolean agregarProducto(Producto p) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un producto en el equipo según su identificador.
     * 
     * @param id Identificador del producto a buscar.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto != null && producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Elimina un producto del equipo reemplazando su posición con null.
     * 
     * @param id Identificador del producto a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminarProducto(int id) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getId() == id) {
                productos[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra todos los productos registrados en el equipo junto con su información general.
     * 
     * @return Texto con la lista de productos o un mensaje si está vacío.
     */
    public String mostrarEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== EQUIPO ESPACIAL ===\n");
        sb.append("Nombre: ").append(nombreEquipo).append("\n");
        sb.append("Tipo: ").append(tipoEquipo).append("\n");
        sb.append("Peso: ").append(peso).append(" kg\n\n");

        boolean hayProductos = false;
        for (Producto producto : productos) {
            if (producto != null) {
                sb.append(producto.toString()).append("\n");
                hayProductos = true;
            }
        }

        if (!hayProductos)
            sb.append("No hay productos registrados en este equipo.\n");

        return sb.toString();
    }
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}
