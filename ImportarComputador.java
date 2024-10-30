import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ImportarComputador {
    public LinkedList<COMPUTADOR_PORTATIL> leerArchivo(String Computadores) {
        String rutaArchivo = Computadores + ".txt";
        LinkedList<COMPUTADOR_PORTATIL> computadores = new LinkedList<>();

        try (Scanner sc = new Scanner(new FileReader(rutaArchivo))) {
            COMPUTADOR_PORTATIL computador = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.trim().isEmpty() || line.startsWith("-")) {
                    continue;
                }

                if (line.startsWith("Serial: ")) {
                    if (computador != null) {
                        computadores.add(computador);
                    }
                    computador = new COMPUTADOR_PORTATIL(null, null, 0, 0, null, null, 0);
                    computador.setSerial(line.substring(8).trim());
                } else if (line.startsWith("Marca: ")) {
                    if (computador != null) {
                        computador.setMarca(line.substring(7).trim());
                    }
                } else if (line.startsWith("Tamaño: ")) {
                    if (computador != null) {
                        computador.setTamaño(Float.parseFloat(line.substring(8).trim()));
                    }
                } else if (line.startsWith("Precio: ")) {
                    if (computador != null) {
                        computador.setPrecio(Float.parseFloat(line.substring(8).trim()));
                    }
                } else if (line.startsWith("Sistema Operativo: ")) {
                    if (computador != null) {
                        computador.setSistemaOp(line.substring(19).trim());
                    }
                } else if (line.startsWith("Procesador: ")) {
                    if (computador != null) {
                        computador.setProcesador(line.substring(12).trim());
                    }
                } else if(line.startsWith("Key: ")){
                    if(computador != null){
                        computador.setKey(Integer.parseInt(line.substring(5).trim()));
                    }
                } else if (line.startsWith("Disponibilidad: ")){
                    if(computador != null){
                        computador.setDisponible(Boolean.parseBoolean(line.substring(16).trim()));
                    }
                }
            }

            if (computador != null) {
                computadores.add(computador);
            }
        } catch (Exception e) {
        }
        return computadores;
    }
}
