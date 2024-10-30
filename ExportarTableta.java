import java.io.FileWriter;
import java.util.LinkedList;

public class ExportarTableta{
    public void exportarArchivo(LinkedList<TABLETA_GRAFICA> listaTableta) {
        if (listaTableta.isEmpty()) {
            Acciones accion = new Acciones();
            listaTableta = accion.crearTabletaGrafica(null);
        } else {
            try (FileWriter escriba = new FileWriter("Tabletas.txt", false)) {
                for (TABLETA_GRAFICA tab : listaTableta) {
                    escriba.write("Serial: " + tab.getSerial() + "\n");
                    escriba.write("Marca: " + tab.getMarca() + "\n");
                    escriba.write("Tamaño: " + tab.getTamaño() + "\n");
                    escriba.write("Precio: " + tab.getPrecio() + "\n");
                    escriba.write("Almacenamiento: " + tab.getAlmacenamiento() + "\n");
                    escriba.write("Peso: " + tab.getPeso() + "\n");
                    escriba.write("Key: " + tab.getKey() + "\n");
                    escriba.write("Disponibilidad: " + tab.isDisponible() + "\n");
                    escriba.write("---------------------------------------\n");

                }
            } catch (Exception e) {
            }
        }
    }
}