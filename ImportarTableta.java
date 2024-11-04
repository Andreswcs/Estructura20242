import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ImportarTableta {
    public LinkedList<TABLETA_GRAFICA> leerArchivo(String Tableta) {
        String rutaArchivo = Tableta + ".txt";
        LinkedList<TABLETA_GRAFICA> tabletas = new LinkedList<>();

        try (Scanner sc = new Scanner(new FileReader(rutaArchivo))) {
            TABLETA_GRAFICA tableta = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.trim().isEmpty() || line.startsWith("-")) {
                    continue;
                }

                if (line.startsWith("Serial: ")) {
                    if (tableta != null) {
                        tabletas.add(tableta);
                    }
                    tableta = new TABLETA_GRAFICA(null, null, 0, 0, null, 0, 0);
                    tableta.setSerial(line.substring(8).trim());
                } else if (line.startsWith("Marca: ")) {
                    if (tableta != null) {
                        tableta.setMarca(line.substring(7).trim());
                    }
                } else if (line.startsWith("Tamaño: ")) {
                    if (tableta != null) {
                        tableta.setTamaño(Float.parseFloat(line.substring(8).trim()));
                    }
                } else if (line.startsWith("Precio: ")) {
                    if (tableta != null) {
                        tableta.setPrecio(Float.parseFloat(line.substring(8).trim()));
                    }
                } else if (line.startsWith("Almacenamiento: ")) {
                    if (tableta != null) {
                        tableta.setAlmacenamiento(line.substring(16).trim());
                    }
                } else if (line.startsWith("Peso: ")) {
                    if (tableta != null) {
                        tableta.setPeso(Float.parseFloat(line.substring(6).trim()));
                    }
                } else if (line.startsWith("Key: ")) {
                    if (tableta != null) {
                        tableta.setKey(Integer.parseInt(line.substring(5).trim()));
                    }
                } else if (line.startsWith("Disponibilidad: ")) {
                    if (tableta != null) {
                        tableta.setDisponible(Boolean.parseBoolean(line.substring(16).trim()));
                    }
                }
            }

            if (tableta != null) {
                tabletas.add(tableta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tabletas;
    }
}