package co.edu.poli.espacio.model;

/**
 * Subclase de Producto que representa alimentos espaciales.
 * Incluye información adicional como la fecha de vencimiento
 * y el tipo de alimento.
 * 
 * @author Kevin
 * @version 1.0
 * @since 2025-10-21
 */
public class ProductoAlimenticio extends Producto {

    private String fechaVencimiento;
    private String tipoAlimento;

    public ProductoAlimenticio() {
        super();
    }

    public ProductoAlimenticio(int id, String nombre, String descripcion, int cantidad,
                               String fechaVencimiento, String tipoAlimento) {
        super(id, nombre, descripcion, cantidad, tipoAlimento, tipoAlimento);
        this.fechaVencimiento = fechaVencimiento;
        this.tipoAlimento = tipoAlimento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public String toString() {
        return super.toString() + " [Alimento: " + tipoAlimento + ", vence: " + fechaVencimiento + "]";
    }
}
