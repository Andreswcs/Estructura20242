import java.io.FileWriter;
import java.util.LinkedList;

public class ExportarIngenieros {
    public void exportarArchivo(LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros) {
        if (listaIngenieros.isEmpty()) {
            Acciones accion = new Acciones();
            listaIngenieros = accion.registrarEstudianteIngenieros(null, null);
        } else {
            try (FileWriter escriba = new FileWriter("Ingenieros.txt", false)) {
                for (ESTUDIANTE_INGENIERIA inge : listaIngenieros) {
                    escriba.write("Cedula: " + inge.getCedula() + "\n");
                    escriba.write("Nombre: " + inge.getNombre() + "\n");
                    escriba.write("Apellido: " + inge.getApellido() + "\n");
                    escriba.write("Telefono: " + inge.getTelefono() + "\n");
                    escriba.write("Semestre: " + inge.getSemestre() + "\n");
                    escriba.write("Serial: " + inge.getSerial() + "\n");
                    escriba.write("Promedio: " + inge.getPromedio() + "\n");
                    escriba.write("Presamo: "+ inge.isPrestamo() + "\n");
                    escriba.write("Key: " + inge.getKey() + "\n");
                    escriba.write("---------------------------------------\n");

                }
            } catch (Exception e) {
            }
        }
    }
}
