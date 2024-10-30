import java.io.FileWriter;
import java.util.LinkedList;

public class ExportarPortatil{
    public void exportarArchivo(LinkedList<COMPUTADOR_PORTATIL> listaComputadores) {
        if (listaComputadores.isEmpty()) {
            Acciones accion = new Acciones();
            listaComputadores = accion.crearComputadorPortatil(listaComputadores);
        } else {
            try (FileWriter escriba = new FileWriter("Computadores.txt", false)) {
                for (COMPUTADOR_PORTATIL compu : listaComputadores) {
                    escriba.write("Serial: " + compu.getSerial() + "\n");
                    escriba.write("Marca: " + compu.getMarca() + "\n");
                    escriba.write("Tamaño: " + compu.getTamaño() + "\n");
                    escriba.write("Precio: " + compu.getPrecio() + "\n");
                    escriba.write("Sistema Operativo: " + compu.getSistemaOp() + "\n");
                    escriba.write("Procesador: " + compu.getProcesador() + "\n");
                    escriba.write("Key: " + compu.getKey() + "\n");
                    escriba.write("Disponibilidad: " + compu.isDisponible() + "\n");
                    escriba.write("---------------------------------------\n");

                }
            } catch (Exception e) {
            }
        }
    }
}