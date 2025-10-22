package co.edu.poli.espacio.visual;

import java.io.*;
import java.util.Scanner;
import co.edu.poli.espacio.model.Producto;
import co.edu.poli.espacio.servicios.*;

/**
 * Clase principal que permite gestionar productos espaciales mediante un menú en consola.
 * Incluye funcionalidad de serialización y deserialización de los productos.
 * 
 * Aplica el patrón MVC, actuando como la Vista del sistema.
 * 
 * Permite crear, leer, actualizar, eliminar y guardar los productos en un archivo binario.
 * 
 * @author Kevin
 * @author Nicolas
 * @version 1.5
 * @since 2025-10-21
 */
public class Cliente {

    private static final String ARCHIVO = "productos.dat";
    private static ImplOperacionCrud crud = new ImplOperacionCrud();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("GESTION DE PRODUCTOS ESPACIALES");
            System.out.println("1. Crear producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Guardar productos (Serializar)");
            System.out.println("7. Cargar productos (Deserializar)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("ID del producto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Cantidad disponible: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Proveedor: ");
                    String proveedor = sc.nextLine();
                    System.out.print("Estado (activo, agotado, etc.): ");
                    String estado = sc.nextLine();

                    Producto nuevo = new Producto(id, nombre, descripcion, cantidad, proveedor, estado);
                    String resultado = crud.create(nuevo);
                    System.out.println(resultado);
                    pausar();
                }

                case 2 -> {
                    Producto[] productos = crud.readAll();
                    boolean hayProductos = false;
                    System.out.println("LISTA DE PRODUCTOS");
                    for (Producto p : productos) {
                        if (p != null) {
                            System.out.println(p);
                            hayProductos = true;
                        }
                    }
                    if (!hayProductos)
                        System.out.println("No hay productos registrados.");
                    pausar();
                }

                case 3 -> {
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    String id = sc.nextLine();
                    Producto p = crud.readId(id);
                    if (p != null)
                        System.out.println("Producto encontrado:" + p);
                    else
                        System.out.println("No se encontro el producto con ID " + id);
                    pausar();
                }

                case 4 -> {
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    String id = sc.nextLine();
                    Producto pExistente = crud.readId(id);

                    if (pExistente != null) {
                        System.out.print("Nuevo nombre (" + pExistente.getNombre() + "): ");
                        String nombre = sc.nextLine();
                        System.out.print("Nueva descripcion (" + pExistente.getDescripcion() + "): ");
                        String descripcion = sc.nextLine();
                        System.out.print("Nueva cantidad (" + pExistente.getCantidad() + "): ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nuevo proveedor (" + pExistente.getProveedor() + "): ");
                        String proveedor = sc.nextLine();
                        System.out.print("Nuevo estado (" + pExistente.getEstado() + "): ");
                        String estado = sc.nextLine();

                        Producto actualizado = new Producto(pExistente.getId(), nombre, descripcion, cantidad, proveedor, estado);
                        String mensaje = crud.update(id, actualizado);
                        System.out.println(mensaje);
                    } else {
                        System.out.println("No se encontro un producto con ese ID.");
                    }
                    pausar();
                }

                case 5 -> {
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    String id = sc.nextLine();
                    Producto eliminado = crud.delete(id);
                    if (eliminado != null)
                        System.out.println("Producto eliminado:\n" + eliminado);
                    else
                        System.out.println("No se encontro un producto con ID " + id);
                    pausar();
                }

                case 6 -> {
                    serializar();
                    System.out.println("Productos guardados exitosamente en archivo.");
                    pausar();
                }

                case 7 -> {
                    deserializar();
                    System.out.println("Productos cargados exitosamente desde archivo.");
                    pausar();
                }

                case 8 -> System.out.println("Saliendo del sistema...");

                default -> {
                    System.out.println("Opcion no valida.");
                    pausar();
                }
            }

        } while (opcion != 8);

        sc.close();
    }

    /**
     * Guarda los productos en un archivo binario (serializacion).
     */
    private static void serializar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(crud.getProductos());
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }

    /**
     * Carga los productos desde un archivo binario (deserializacion).
     */
    private static void deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Producto[] cargados = (Producto[]) ois.readObject();
            crud.setProductos(cargados);
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }

    /**
     * Espera que el usuario presione ENTER antes de continuar.
     */
    private static void pausar() {
        System.out.println("Presione ENTER para continuar...");
        sc.nextLine();
    }
}
