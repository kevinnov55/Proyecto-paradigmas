package co.edu.poli.espacio.model;

/**
 * Clase que representa un producto tecnológico dentro del sistema espacial.
 * Este tipo de producto puede incluir dispositivos electrónicos,
 * herramientas energizadas o equipos de comunicación.
 * 
 * Contiene información sobre el tipo de energía que usa, su peso
 * y el nivel de consumo energético.
 * 
 * Esta clase hereda de {@link Producto}, agregando características
 * específicas para los productos tecnológicos.
 * 
 * @author Kevin Ovalle
 * @author Nicolás Fajardo
 * @version 1.2
 * @since 2025-10-21
 */
public class ProductoTecnologico extends Producto {

    private String tipoEnergia;
    private double peso;
    private double consumoEnergia;

    /**
     * Constructor vacío.
     */
    public ProductoTecnologico() {
        super();
    }

    /**
     * Constructor que inicializa todos los atributos del producto tecnológico.
     * 
     * @param id              Identificador único del producto.
     * @param nombre          Nombre del producto.
     * @param descripcion     Descripción del producto.
     * @param cantidad        Cantidad disponible.
     * @param proveedor       Proveedor del producto.
     * @param estado          Estado actual del producto.
     * @param tipoEnergia     Tipo de energía que utiliza (solar, eléctrica, etc.).
     * @param peso            Peso del producto (en kilogramos).
     * @param consumoEnergia  Consumo energético (en vatios o equivalente).
     */
    public ProductoTecnologico(int id, String nombre, String descripcion, int cantidad,
            String proveedor, String estado, String tipoEnergia, double peso, double consumoEnergia) {

        super(id, nombre, descripcion, cantidad, proveedor, estado);
        this.tipoEnergia = tipoEnergia;
        this.peso = peso;
        this.consumoEnergia = consumoEnergia;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    /**
     * Devuelve una representación textual del producto tecnológico.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Tipo de Energía=" + tipoEnergia +
                ", Peso=" + peso + " kg" +
                ", Consumo Energético=" + consumoEnergia + " W]";
    }
}

