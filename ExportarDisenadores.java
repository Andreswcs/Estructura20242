import java.io.FileWriter;
import java.util.LinkedList;

public class ExportarDisenadores {
    public void exportarArchivo(LinkedList<ESTUDIANTE_DISENO> listaDisenadores) {
        if (listaDisenadores.isEmpty()) {
            Acciones accion = new Acciones();
            listaDisenadores = accion.registrarEstudianteDiseños(null, null);
        } else {
            try (FileWriter escriba = new FileWriter("Disenadores.txt", false)) {
                for (ESTUDIANTE_DISENO dise : listaDisenadores) {
                    escriba.write("Cedula: " + dise.getCedula() + "\n");
                    escriba.write("Nombre: " + dise.getNombre() + "\n");
                    escriba.write("Apellido: " + dise.getApellido() + "\n");
                    escriba.write("Telefono: " + dise.getTelefono() + "\n");
                    escriba.write("Asignaturas: " + dise.getAsignaturas() + "\n");
                    escriba.write("Serial: " + dise.getSerial() + "\n");
                    escriba.write("Modalidad: " + dise.getModalidad() + "\n");
                    escriba.write("Prestamo: " + dise.isPrestamo() + "\n");
                    escriba.write("Key: " + dise.getKey() + "\n");
                    escriba.write("---------------------------------------\n");

                }
            } catch (Exception e) {
            }
        }
    }
}
