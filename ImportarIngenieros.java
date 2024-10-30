import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ImportarIngenieros {

    public LinkedList<ESTUDIANTE_INGENIERIA> leerArchivo(String Ingenieros) {
        String rutaArchivo = Ingenieros + ".txt";
        LinkedList<ESTUDIANTE_INGENIERIA> ingenieros = new LinkedList<>();

        try (Scanner sc = new Scanner(new FileReader(rutaArchivo))) {
            ESTUDIANTE_INGENIERIA ingeniero = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.trim().isEmpty() || line.startsWith("-")) {
                    continue;
                }

                if (line.startsWith("Cedula: ")) {
                    if (ingeniero != null) {
                        ingenieros.add(ingeniero);
                    }
                    ingeniero = new ESTUDIANTE_INGENIERIA(null, null, null, null, 0, 0, null, 0);
                    ingeniero.setCedula(line.substring(8).trim());
                } else if (line.startsWith("Nombre: ")) {
                    if (ingeniero != null) {
                        ingeniero.setNombre(line.substring(8).trim());
                    }
                } else if (line.startsWith("Apellido: ")) {
                    if (ingeniero != null) {
                        ingeniero.setApellido(line.substring(10).trim());
                    }
                } else if (line.startsWith("Telefono: ")) {
                    if (ingeniero != null) {
                        ingeniero.setTelefono(line.substring(10).trim());
                    }
                } else if (line.startsWith("Semestre: ")) {
                    if (ingeniero != null) {
                        ingeniero.setSemestre(Integer.parseInt(line.substring(10).trim()));
                    }
                } else if (line.startsWith("Serial: ")) {
                    if (ingeniero != null) {
                        ingeniero.setSerial(line.substring(8).trim());
                    }
                } else if (line.startsWith("Promedio: ")) {
                    if (ingeniero != null) {
                        ingeniero.setPromedio(Float.parseFloat(line.substring(10).trim()));
                    }
                } else if (line.startsWith("Prestamo: ")) {
                    if (ingeniero != null) {
                        ingeniero.setPrestamo(Boolean.parseBoolean(line.substring(10).trim()));
                    }
                } else if (line.startsWith("Key: ")) {
                    if (ingeniero != null) {
                        ingeniero.setKey(Integer.parseInt(line.substring(5).trim()));
                    }
                }
            }

            if (ingeniero != null) {
                ingenieros.add(ingeniero);
            }
        } catch (Exception e) {
        }
        return ingenieros;
    }
}