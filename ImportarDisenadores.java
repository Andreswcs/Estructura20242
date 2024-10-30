import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ImportarDisenadores {
    public LinkedList<ESTUDIANTE_DISENO> leerArchivo(String Disenadores) {
        String rutaArchivo = Disenadores + ".txt";
        LinkedList<ESTUDIANTE_DISENO> disenadores = new LinkedList<>();

        try (Scanner sc = new Scanner(new FileReader(rutaArchivo))) {
            ESTUDIANTE_DISENO disenador = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.trim().isEmpty() || line.startsWith("-")) {
                    continue;
                }

                if (line.startsWith("Cedula: ")) {
                    if (disenador != null) {
                        disenadores.add(disenador);
                    }
                    disenador = new ESTUDIANTE_DISENO(null, null, null, null, null, 0, null);
                    disenador.setCedula(line.substring(8).trim());
                } else if (line.startsWith("Nombre: ")) {
                    if (disenador != null) {
                        disenador.setNombre(line.substring(8).trim());
                    }
                } else if (line.startsWith("Apellido: ")) {
                    if (disenador != null) {
                        disenador.setApellido(line.substring(10).trim());
                    }
                } else if (line.startsWith("Telefono: ")) {
                    if (disenador != null) {
                        disenador.setTelefono(line.substring(10).trim());
                    }
                } else if (line.startsWith("Asignaturas: ")) {
                    if (disenador != null) {
                        disenador.setAsignaturas(Integer.parseInt(line.substring(13).trim()));
                    }
                } else if (line.startsWith("Serial: ")) {
                    if (disenador != null) {
                        disenador.setSerial(line.substring(8).trim());
                    }
                } else if (line.startsWith("Modalidad: ")) {
                    if (disenador != null) {
                        disenador.setModalidad(line.substring(11).trim());
                    }
                 } else if (line.startsWith("Prestamo: ")){
                    if(disenador != null){
                        disenador.setPrestamo(Boolean.parseBoolean(line.substring(10).trim()));
                    }
                }else if (line.startsWith("Key: ")){
                    if(disenador != null){
                        disenador.setKey(Integer.parseInt(line.substring(5).trim()));
                    }
                }
            }

            if (disenador != null) {
                disenadores.add(disenador);
            }
        } catch (Exception e) {
        }
        return disenadores;
    }
}