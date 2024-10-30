
import java.util.LinkedList;
import java.util.Scanner;

public class Acciones {

    Scanner sc = new Scanner(System.in);
    LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros = new LinkedList<>();
    LinkedList<ESTUDIANTE_DISENO> listaDisenos = new LinkedList<>();
    LinkedList<COMPUTADOR_PORTATIL> listaComputadores = new LinkedList<>();
    LinkedList<TABLETA_GRAFICA> listaTabletas = new LinkedList<>();
    int key = 1;

    public void menuPrincipal() {

        Acciones accion = new Acciones();
        boolean continuar = true;
        boolean continuar2 = true;

        while (continuar2) {
            listaComputadores = accion.ImportarCompu();
            listaTabletas = accion.ImportarTable();

            try {

                while (continuar) {
                    System.out.println("---MENÚ---");
                    System.out.println(
                            "Bienvenido al sistema de prestamo de equipos electrónicos, seleccione una opción:\n"
                                    + "1. INGRESAR EQUIPO\n"
                                    + "2. PRESTAMO\n"
                                    + "3. IMPRIMIR INVENTARIO TOTAL\n"
                                    + "4. SALIR DEL PROGRAMA");
                    int opcionMenu = sc.nextInt();
                    System.out.println("-----------------------------");
                    continuar2 = true;

                    switch (opcionMenu) {
                        case 1:
                            // INGRESAR UN NUEVO EQUIPO A LA BASE DE DATOS
                            while (continuar2) {
                                System.out.println("¿Que tipo de equipo desea ingresar?\n"
                                        + "1. COMPUTADOR PORTATIL\n"
                                        + "2. TABLETA GRAFICA\n"
                                        + "3. Volver al menú principal");

                                int opt = sc.nextInt();

                                switch (opt) {
                                    case 1:
                                        listaComputadores = accion.crearComputadorPortatil(listaComputadores);
                                        continuar2 = false;
                                        break;
                                    case 2:
                                        listaTabletas = accion.crearTabletaGrafica(listaTabletas);
                                        continuar2 = false;
                                        break;
                                    case 3:
                                        continuar2 = false;
                                        break;
                                    default:
                                        System.out.println("Opción no valida");
                                        System.out.println("-----------------");
                                        break;
                                }
                            }
                            break;
                        case 2:
                            // IR AL INICIO
                            accion.inicio(listaComputadores, listaTabletas);
                            break;
                        case 3:
                            // IMPRIMIR INVENTARIO
                            accion.listaEquipos(listaComputadores, listaTabletas);
                            break;
                        case 4:
                            // SALIR
                            continuar = false;
                            break;
                        default:
                            System.out.println("Opción del menú no disponible");
                            break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error de digitación");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public void listaEquipos(LinkedList<COMPUTADOR_PORTATIL> listaComputadores,
            LinkedList<TABLETA_GRAFICA> listaTabletas) {

        if (listaComputadores.isEmpty() && listaTabletas.isEmpty()) {
            System.out.println("No hay equipos registrados");
            return;
        }

        if (!(listaComputadores.isEmpty())) {
            System.out.println("---COMPUTADORES---");
            for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {
                System.out.println("Serial: " + computador_PORTATIL.getSerial());
                System.out.println("Marca: " + computador_PORTATIL.getMarca());
                System.out.println("Tamaño: " + computador_PORTATIL.getTamaño());
                System.out.println("Precio: " + computador_PORTATIL.getPrecio());
                System.out.println("Sistema Operativo: " + computador_PORTATIL.getSistemaOp());
                System.out.println("Procesador: " + computador_PORTATIL.getProcesador());
                System.out.println("Disponibilidad: " + computador_PORTATIL.isDisponible());
                System.out.println("-------------------------------------------");
            }
        }

        if (!(listaTabletas.isEmpty())) {
            System.out.println("---TABLETAS---");
            for (TABLETA_GRAFICA tableta_GRAFICA : listaTabletas) {
                System.out.println("Serial: " + tableta_GRAFICA.getSerial());
                System.out.println("Marca: " + tableta_GRAFICA.getMarca());
                System.out.println("Tamaño: " + tableta_GRAFICA.getTamaño());
                System.out.println("Precio: " + tableta_GRAFICA.getPrecio());
                System.out.println("Almacenamiento: " + tableta_GRAFICA.getAlmacenamiento());
                System.out.println("Peso: " + tableta_GRAFICA.getPeso() + "Kg");
                System.out.println("Disponibilidad: " + tableta_GRAFICA.isDisponible());
                System.out.println("-------------------------------------------");
            }
        }
    }

    public void inicio(LinkedList<COMPUTADOR_PORTATIL> listaComputadores, LinkedList<TABLETA_GRAFICA> listaTabletas) {

        Acciones accion = new Acciones();
        boolean continuar = true;
        ESTUDIANTE_INGENIERIA estudianteIngenieria = new ESTUDIANTE_INGENIERIA(null, null, null, null, 0, 0, null, 0);
        ESTUDIANTE_DISENO estudianteDiseño = new ESTUDIANTE_DISENO(null, null, null, null, null, 0, null);
        while (continuar) {

            try {
                listaDisenos = accion.ImportarDise();
                listaIngenieros = accion.ImportarInge();
                System.out.println("Seleccione una opción:\n"
                        + "1. Estudiante nuevo(registrarse)\n"
                        + "2. Estudiante existente\n"
                        + "3. volver al menu principal");
                int opt = sc.nextInt();
                int opt3;

                if (opt == 1 || opt == 2) {
                    opt3 = accion.tipoEstudiante();
                } else {
                    System.out.println("Opción no valida");
                    break;
                }

                switch (opt) {
                    case 1:

                        if (opt3 == 1) {
                            listaIngenieros = accion.registrarEstudianteIngenieros(listaIngenieros, listaDisenos);
                            break;
                        } else if (opt3 == 2) {
                            listaDisenos = accion.registrarEstudianteDiseños(listaDisenos, listaIngenieros);
                            break;
                        } else {
                            System.out.println("Opción no valida");
                        }
                        break;
                    case 2:

                        if (opt3 == 1) {
                            listaComputadores = accion.ImportarCompu();
                            listaIngenieros = accion.ImportarInge();
                            estudianteIngenieria = accion.idEstudiante_INGENIERIA(listaIngenieros);
                            if (estudianteIngenieria == null) {
                                break;
                            }
                            accion.menuIngenieria(estudianteIngenieria, listaComputadores, listaIngenieros);
                            break;
                        } else if (opt3 == 2) {
                            estudianteDiseño = accion.idEstudiante_DISENO(listaDisenos);
                            if (estudianteDiseño == null) {
                                break;
                            }
                            accion.menuDiseño(estudianteDiseño, listaTabletas, listaDisenos);
                            break;
                        } else {
                            System.out.println("Opción no valida");
                        }
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error de digitación");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public int tipoEstudiante() {

        System.out.println("Seleccione una opción:\n"
                + "1. Estudiante de ingenieria\n"
                + "2. Estudiante de diseño");

        return sc.nextInt();
    }

    public void menuIngenieria(ESTUDIANTE_INGENIERIA estudianteIngenieria,
            LinkedList<COMPUTADOR_PORTATIL> listaComputadores, LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros) {

        Acciones accion = new Acciones();
        boolean continuar = true;
        ExportarIngenieros expoInges = new ExportarIngenieros();
        ExportarPortatil expoCompu = new ExportarPortatil();

        while (continuar) {

            try {

                System.out.println("Bienvenido " + estudianteIngenieria.getNombre() + " "
                        + estudianteIngenieria.getApellido() + ", ¿qué acción desea realizar?\n"
                        + "1. Registrar préstamo de equipo\n"
                        + "2. Modificar préstamo de equipo\n"
                        + "3. Devolución de equipo\n"
                        + "4. Buscar equipo\n"
                        + "5. Volver");
                int opcionMenu = sc.nextInt();
                System.out.println("-----------------------------");

                switch (opcionMenu) {
                    case 1:
                        // Metodo de Registrar préstamo de equipo.
                        accion.prestarComputador(estudianteIngenieria, listaComputadores);
                        expoInges.exportarArchivo(listaIngenieros);
                        expoCompu.exportarArchivo(listaComputadores);
                        listaComputadores = accion.ImportarCompu();
                        listaIngenieros = accion.ImportarInge();

                        break;
                    case 2:
                        // Metodo de Modificar préstamo de equipo.
                        accion.modificarPrestamoIngeniero(estudianteIngenieria, listaComputadores, listaIngenieros);
                        break;
                    case 3:
                        // Metodo de Devoluvion préstamo de equipo.
                        accion.devolucionComputador(estudianteIngenieria, listaComputadores);
                        expoInges.exportarArchivo(listaIngenieros);
                        expoCompu.exportarArchivo(listaComputadores);
                        listaComputadores = accion.ImportarCompu();
                        listaIngenieros = accion.ImportarInge();

                        break;
                    case 4:
                        // Metodo de buscar equipo.
                        accion.buscarComputador(estudianteIngenieria, listaComputadores);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error de digitación");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public void menuDiseño(ESTUDIANTE_DISENO estudianteDiseño, LinkedList<TABLETA_GRAFICA> listaTabletas,
            LinkedList<ESTUDIANTE_DISENO> listaDisenos) {

        Acciones accion = new Acciones();
        boolean continuar = true;

        while (continuar) {

            try {

                System.out.println("Bienvenido " + estudianteDiseño.getNombre() + " " + estudianteDiseño.getApellido()
                        + ", ¿qué acción desea realizar?\n"
                        + "1. Registrar préstamo de equipo\n"
                        + "2. Modificar préstamo de equipo\n"
                        + "3. Devolución de equipo\n"
                        + "4. Buscar equipo\n"
                        + "5. Volver");
                int opcionMenu = sc.nextInt();
                System.out.println("-----------------------------");

                switch (opcionMenu) {
                    case 1:
                        // Metodo de Registrar préstamo de equipo.
                        accion.prestarTableta(estudianteDiseño, listaTabletas);
                        break;
                    case 2:
                        // Metodo de Modificar préstamo de equipo.
                        accion.modificarPrestamoDiseños(estudianteDiseño, listaTabletas, listaDisenos);
                        break;
                    case 3:
                        // Metodo de Devoluvion préstamo de equipo.
                        accion.devolucionTableta(estudianteDiseño, listaTabletas);
                        break;
                    case 4:
                        // Metodo de buscar equipo.
                        accion.buscarTableta(estudianteDiseño, listaTabletas);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error de digitación");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public LinkedList<ESTUDIANTE_INGENIERIA> registrarEstudianteIngenieros(
            LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros, LinkedList<ESTUDIANTE_DISENO> listaDisenos) {
        // En un primer registro, la lista llega vacia, entonces se añade el primer
        // prestamo y se actualiza esa lista "vacia" fuera de este metodo(menu)

        LinkedList<ESTUDIANTE_INGENIERIA> lista = listaIngenieros;
        ESTUDIANTE_INGENIERIA estudiante = new ESTUDIANTE_INGENIERIA(null, null,
                null, null, 0, 0, null, 0);

        System.out.println("Rellene los siguientes datos:");
        System.out.println("Cedula:");
        estudiante.setCedula(sc.next());

        for (ESTUDIANTE_INGENIERIA estudiante_INGENIERIA : listaIngenieros) {
            if (estudiante.getCedula().equals(estudiante_INGENIERIA.getCedula())) {
                System.out.println("Este estudiante ya existe en la base de datos");
                return listaIngenieros;
            }
        }

        System.out.println("Nombre:");
        estudiante.setNombre(sc.next().toLowerCase());
        System.out.println("Apellido:");
        estudiante.setApellido(sc.next().toLowerCase());
        System.out.println("Telefono:");
        estudiante.setTelefono(sc.next());
        System.out.println("Semestre:");
        estudiante.setSemestre(sc.nextInt());
        System.out.println("Promedio:");
        estudiante.setPromedio(sc.nextFloat());
        System.out.println("Serial:");
        estudiante.setSerial(sc.next());

        for (ESTUDIANTE_INGENIERIA estudiante_INGENIERIA : listaIngenieros) {
            if (estudiante.getSerial().equals(estudiante_INGENIERIA.getSerial())) {
                System.out.println("Este serial ya existe en la base de datos");
                return listaIngenieros;
            }
        }

        for (ESTUDIANTE_DISENO estudiante_DISENO : listaDisenos) {
            if (estudiante.getSerial().equals(estudiante_DISENO.getSerial())) {
                System.out.println("Este serial ya existe en la base de datos");
                return listaIngenieros;
            }
        }

        lista.add(estudiante);
        System.out.println("---REGISTRO EXITOSO---");
        ExportarIngenieros e = new ExportarIngenieros();
        e.exportarArchivo(listaIngenieros);
        return lista;
    }

    public LinkedList<ESTUDIANTE_INGENIERIA> ImportarInge() {
        ImportarIngenieros i = new ImportarIngenieros();
        LinkedList<ESTUDIANTE_INGENIERIA> lista = i.leerArchivo("Ingenieros");
        return lista;
    }

    public LinkedList<ESTUDIANTE_DISENO> registrarEstudianteDiseños(
            LinkedList<ESTUDIANTE_DISENO> listaDisenos, LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros) {

        LinkedList<ESTUDIANTE_DISENO> lista = listaDisenos;
        ESTUDIANTE_DISENO estudiante = new ESTUDIANTE_DISENO(null, null, null,
                null, null, 0, null);

        System.out.println("Rellene los siguientes datos:");
        System.out.println("Cedula:");
        estudiante.setCedula(sc.next());

        for (ESTUDIANTE_DISENO estudiante_DISENO : listaDisenos) {
            if (estudiante.getCedula().equals(estudiante_DISENO.getCedula())) {
                System.out.println("Este estudiante ya existe en la base de datos");
                return listaDisenos;
            }
        }

        System.out.println("Nombre:");
        estudiante.setNombre(sc.next().toLowerCase());
        System.out.println("Apellido:");
        estudiante.setApellido(sc.next().toLowerCase());
        System.out.println("Telefono:");
        estudiante.setTelefono(sc.next());
        System.out.println("Modalidad:");
        estudiante.setModalidad(sc.next());
        System.out.println("Asignaturas:");
        estudiante.setAsignaturas(sc.nextInt());
        System.out.println("Serial:");
        estudiante.setSerial(sc.next());

        for (ESTUDIANTE_INGENIERIA estudiante_INGENIERIA : listaIngenieros) {
            if (estudiante.getSerial().equals(estudiante_INGENIERIA.getSerial())) {
                System.out.println("Este serial ya existe en la base de datos");
                return listaDisenos;
            }
        }

        for (ESTUDIANTE_DISENO estudiante_DISENO : listaDisenos) {
            if (estudiante.getSerial().equals(estudiante_DISENO.getSerial())) {
                System.out.println("Este serial ya existe en la base de datos");
                return listaDisenos;
            }
        }

        lista.add(estudiante);
        System.out.println("---REGISTRO EXITOSO---");
        ExportarDisenadores e = new ExportarDisenadores();
        e.exportarArchivo(listaDisenos);
        return lista;
    }

    public LinkedList<ESTUDIANTE_DISENO> ImportarDise() {
        ImportarDisenadores i = new ImportarDisenadores();
        LinkedList<ESTUDIANTE_DISENO> lista = i.leerArchivo("Disenadores");
        return lista;
    }

    public LinkedList<COMPUTADOR_PORTATIL> crearComputadorPortatil(
            LinkedList<COMPUTADOR_PORTATIL> listaComputadores) {

        Acciones accion = new Acciones();
        LinkedList<COMPUTADOR_PORTATIL> lista = listaComputadores;

        System.out.println("Ingrese la cantidad de computadores que desea agregar al sistema:");
        int cantidad = sc.nextInt();
        boolean bandera = true;
        boolean bandera2 = true;
        int num = 1;

        if (cantidad == 0) {
            System.out.println("--------------------------------");
            return listaComputadores;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Registre los datos del computador #" + num + ":");
            bandera2 = true;
            while (bandera2) {

                COMPUTADOR_PORTATIL computador = new COMPUTADOR_PORTATIL(null, null, 0, 0, null, null, 0);
                System.out.println("Serial:");
                computador.setSerial("CP" + sc.next());
                bandera = true; // La bandera se reinicia a true, por que si en algun momento se ingreso un
                                // mismo seria,
                // hay que reiniciar esta bandera

                for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {
                    if (computador_PORTATIL.getSerial().equals(computador.getSerial())) {
                        System.out.println("Parece que este computador ya esta registrado en el sistema");
                        bandera = false;
                        break;
                    }
                }

                if (!bandera) {
                    System.out.println("Valide la información y reingrese los datos\n");
                    System.out.println("------------------------------------------");
                    i--;
                } else {
                    System.out.println("Marca:");
                    computador.setMarca(sc.next().toLowerCase());
                    System.out.println("Tamaño (pulgadas):");
                    computador.setTamaño(sc.nextFloat());
                    System.out.println("Precio:");
                    computador.setPrecio(sc.nextFloat());
                    computador.setSistemaOp(accion.sistemaOp());
                    computador.setProcesador(accion.procesador());

                    for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {
                        if (computador_PORTATIL.getKey() == key) {
                            key++;
                        }
                    }
                    computador.setKey(key);

                    lista.add(computador);
                    bandera2 = false;
                    num++;
                }
                bandera2 = false;
            }
        }

        System.out.println("---REGISTRO EXITOSO---\n");

        ExportarPortatil e = new ExportarPortatil();
        e.exportarArchivo(lista);

        return lista;
    }

    public LinkedList<COMPUTADOR_PORTATIL> ImportarCompu() {
        ImportarComputador e = new ImportarComputador();
        LinkedList<COMPUTADOR_PORTATIL> lista = e.leerArchivo("Computadores");
        return lista;
    }

    public LinkedList<TABLETA_GRAFICA> crearTabletaGrafica(
            LinkedList<TABLETA_GRAFICA> listaTableta) {

        Acciones accion = new Acciones();
        LinkedList<TABLETA_GRAFICA> lista = listaTableta;

        System.out.println("Ingrese la cantidad de tabletas que desea agregar al sistema:");
        int cantidad = sc.nextInt();
        boolean bandera = true;
        boolean bandera2 = true;
        int num = 1;

        if (cantidad == 0) {
            System.out.println("--------------------------------");

            return listaTableta;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Registre los datos de la tableta #" + num + ":");
            bandera2 = true;

            while (bandera2) {

                TABLETA_GRAFICA tableta = new TABLETA_GRAFICA(null, null, 0, 0, null, 0, 0);
                System.out.println("Serial:");
                tableta.setSerial("TG" + sc.next());
                bandera = true; // La bandera se reinicia a true, por que si en algun momento se ingreso un
                                // mismo seria,
                // hay que reiniciar esta bandera

                for (TABLETA_GRAFICA tableta_GRAFICA : listaTableta) {
                    if (tableta_GRAFICA.getSerial().equals(tableta.getSerial())) {
                        System.out.println("Parece que esta tableta ya esta registrada en el sistema");
                        bandera = false;
                        break;
                    }
                }

                if (!bandera) {
                    System.out.println("Valide la información y reingrese los datos\n");
                    System.out.println("------------------------------------------");
                    i--;
                } else {
                    System.out.println("Marca:");
                    tableta.setMarca(sc.next());
                    System.out.println("Tamaño (pulgadas):");
                    tableta.setTamaño(sc.nextFloat());
                    System.out.println("Precio:");
                    tableta.setPrecio(sc.nextFloat());
                    tableta.setAlmacenamiento(accion.almacenamiento());
                    System.out.println("Peso (Kilogramos)");
                    tableta.setPeso(sc.nextFloat());

                    for (TABLETA_GRAFICA tableta_GRAFICA : listaTableta) {
                        if (tableta_GRAFICA.getKey() == key) {
                            key++;
                        }
                    }
                    tableta.setKey(key);

                    lista.add(tableta);
                    bandera2 = false;
                    num++;
                }
                bandera2 = false;
            }
        }
        System.out.println("---REGISTRO EXITOSO---\n");

        ExportarTableta e = new ExportarTableta();
        e.exportarArchivo(lista);

        return lista;
    }

    public LinkedList<TABLETA_GRAFICA> ImportarTable() {
        ImportarTableta i = new ImportarTableta();
        LinkedList<TABLETA_GRAFICA> lista = new LinkedList<>();
        lista = i.leerArchivo("Tabletas");
        return lista;
    }

    public String sistemaOp() {

        // HACER CONTROL DE ERRORES
        String sistemaOp = "";

        System.out.println("¿Que sistema operativo desea?\n"
                + "1. Windows 7\n"
                + "2. Windows 10\n"
                + "3. Windows 11");

        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                sistemaOp = "Windows 7";
                break;
            case 2:
                sistemaOp = "Windows 10";
                break;
            case 3:
                sistemaOp = "Windows 11";
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
        return sistemaOp;
    }

    public String procesador() {

        // HACER CONTROL DE ERRORES
        String procesador = "";

        System.out.println("¿Que procesador desea?\n"
                + "1. AMD Ryzen\n"
                + "2. Intel® Core™ i5");

        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                procesador = "AMD Ryzen";
                break;
            case 2:
                procesador = "Intel® Core™ i5";
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
        return procesador;
    }

    public String almacenamiento() {

        String almacenamiento = "";

        System.out.println("¿Que almacenamiento desea?\n"
                + "1. 256 GB\n"
                + "2. 512 GB\n"
                + "3. 1 TB");

        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                almacenamiento = "256 GB";
                break;
            case 2:
                almacenamiento = "512 GB";
                break;
            case 3:
                almacenamiento = "1 TB";
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
        return almacenamiento;
    }

    public ESTUDIANTE_INGENIERIA idEstudiante_INGENIERIA(LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros) {

        ESTUDIANTE_INGENIERIA estudiante = new ESTUDIANTE_INGENIERIA(null, null, null, null, 0, 0, null, 0);
        boolean bandera = false;

        if (listaIngenieros.isEmpty()) {
            System.out.println("No hay Ingenieros registrados");
            return null;
        }

        System.out.println("Digite su cedula o su serial asociado:");
        String idEstudiante = sc.next();

        for (ESTUDIANTE_INGENIERIA estudiante_INGENIERIA : listaIngenieros) {
            if (estudiante_INGENIERIA.getCedula().equals(idEstudiante)
                    || estudiante_INGENIERIA.getSerial().equals(idEstudiante)) {
                estudiante = estudiante_INGENIERIA;
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            System.out.println("No se encontro ningun estudiante registrado con ese serial o cedula... valide");
            return null;
        }
        return estudiante;
    }

    public ESTUDIANTE_DISENO idEstudiante_DISENO(LinkedList<ESTUDIANTE_DISENO> listaDisenos) {

        ESTUDIANTE_DISENO estudiante = new ESTUDIANTE_DISENO(null, null, null, null, null, 0, null);
        boolean bandera = false;

        if (listaDisenos.isEmpty()) {
            System.out.println("No hay diseñadores registrados");
            return null;
        }

        System.out.println("Digite su cedula o su serial asociado:");
        String idEstudiante = sc.next();

        for (ESTUDIANTE_DISENO estudiante_DISENO : listaDisenos) {
            if (estudiante_DISENO.getCedula().equals(idEstudiante)
                    || estudiante_DISENO.getSerial().equals(idEstudiante)) {
                estudiante = estudiante_DISENO;
                bandera = true;
                break;
            }
        }

        if (!bandera) {
            System.out.println("No se encontro ningun estudiante registrado con ese serial o cedula... valide");
            return null;
        }
        return estudiante;
    }

    public COMPUTADOR_PORTATIL prestarComputador(ESTUDIANTE_INGENIERIA estudiante,
            LinkedList<COMPUTADOR_PORTATIL> listaComputadores) {

        COMPUTADOR_PORTATIL computador = new COMPUTADOR_PORTATIL(null, null, 0, 0, null, null, 0);
        Acciones accion = new Acciones();
        boolean bandera = false;

        if (listaComputadores.isEmpty()) {
            System.out.println("No hay computadores disponibles\n");
            return null;
        }

        if (estudiante.isPrestamo()) {
            System.out.println("El estudiante " + estudiante.getNombre() + " " + estudiante.getApellido()
                    + " ya tiene un prestamo activo\n");
            return null;
        }

        String sistemaOp = accion.sistemaOp();
        String procesador = accion.procesador();

        for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {
            if (computador_PORTATIL.getSistemaOp().equals(sistemaOp)
                    && computador_PORTATIL.getProcesador().equals(procesador) && computador_PORTATIL.isDisponible()) {
                System.out.println("Felicidades " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("El préstamo ha sido exitoso, su computador asociado es:\n");
                System.out.println("Serial: " + computador_PORTATIL.getSerial());
                System.out.println("Marca: " + computador_PORTATIL.getMarca());
                System.out.println("Tamaño: " + computador_PORTATIL.getTamaño());
                System.out.println("Precio: " + computador_PORTATIL.getPrecio());
                System.out.println("Sistema Operativo: " + computador_PORTATIL.getSistemaOp());
                System.out.println("Procesador: " + computador_PORTATIL.getProcesador());
                System.out.println("-------------------------------------------");

                estudiante.setKey(computador_PORTATIL.getKey());
                estudiante.setPrestamo(true);
                computador_PORTATIL.setDisponible(false);
                bandera = true;
                computador = computador_PORTATIL;

                break;
            }
        }

        if (!bandera) {
            System.out.println("No hay computador disponible con estos requisitos\n");
            return null;
        }

        return computador;
    }

    public TABLETA_GRAFICA prestarTableta(ESTUDIANTE_DISENO estudiante, LinkedList<TABLETA_GRAFICA> listaTabletas) {

        TABLETA_GRAFICA tableta = new TABLETA_GRAFICA(null, null, 0, 0, null, 0, 0);
        Acciones accion = new Acciones();
        boolean bandera = false;

        if (listaTabletas.isEmpty()) {
            System.out.println("No hay tabletas disponibles\n");
            return null;
        }

        if (estudiante.isPrestamo()) {
            System.out.println("El estudiante " + estudiante.getNombre() + " " + estudiante.getApellido()
                    + " ya tiene un prestamo activo\n");
            return null;
        }

        String almacenamiento = accion.almacenamiento();

        for (TABLETA_GRAFICA tableta_GRAFICA : listaTabletas) {
            if (tableta_GRAFICA.getAlmacenamiento().equals(almacenamiento) && tableta_GRAFICA.isDisponible()) {
                System.out.println("Felicidades " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("El préstamo ha sido exitoso, su tableta asociada es:\n");
                System.out.println("Serial: " + tableta_GRAFICA.getSerial());
                System.out.println("Marca: " + tableta_GRAFICA.getMarca());
                System.out.println("Tamaño: " + tableta_GRAFICA.getTamaño());
                System.out.println("Precio: " + tableta_GRAFICA.getPrecio());
                System.out.println("Almacenamiento: " + tableta_GRAFICA.getAlmacenamiento());
                System.out.println("Peso: " + tableta_GRAFICA.getPeso() + "Kg");
                System.out.println("-------------------------------------------");

                estudiante.setKey(tableta_GRAFICA.getKey());
                estudiante.setPrestamo(true);
                tableta_GRAFICA.setDisponible(false);
                bandera = true;
                tableta = tableta_GRAFICA;
                break;
            }
        }

        if (!bandera) {
            System.out.println("No hay tableta disponible con estos requisitos\n");
            return null;
        }
        return tableta;
    }

    public LinkedList<COMPUTADOR_PORTATIL> modificarPrestamoIngeniero(ESTUDIANTE_INGENIERIA estudianteIngenieria,
            LinkedList<COMPUTADOR_PORTATIL> listaComputadores, LinkedList<ESTUDIANTE_INGENIERIA> listaIngenieros) {

        Acciones accion = new Acciones();
        boolean bandera = false;
        ESTUDIANTE_INGENIERIA estudianteNuevo = new ESTUDIANTE_INGENIERIA(null, null, null, null, 0, 0, null, 0);
        COMPUTADOR_PORTATIL computador = new COMPUTADOR_PORTATIL(null, null, 0, 0, null, null, 0);
        for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {

            if (estudianteIngenieria.getKey() == computador_PORTATIL.getKey()) {
                System.out.println("¿Estas seguro que quieres modificar este prestamo?\n"
                        + "1. SI\n"
                        + "2. NO");

                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        break;
                    case 2:
                        return null;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

                estudianteIngenieria.setKey(0);
                estudianteIngenieria.setPrestamo(false);
                computador = computador_PORTATIL;
                bandera = true;
                System.out.println("");
                break;
            } else {
                System.out.println("Este estudiante no tiene ningun equipo asociado");
                break;
            }
        }

        if (bandera) {

            estudianteNuevo = accion.idEstudiante_INGENIERIA(listaIngenieros);
            estudianteNuevo.setKey(computador.getKey());
            estudianteNuevo.setPrestamo(true);
            System.out.println("---MODIFICACÓN EXITOSA---\n");
        }
        return null;
    }

    public LinkedList<TABLETA_GRAFICA> modificarPrestamoDiseños(ESTUDIANTE_DISENO estudianteDiseno,
            LinkedList<TABLETA_GRAFICA> listaTabletas, LinkedList<ESTUDIANTE_DISENO> listaDisenos) {

        Acciones accion = new Acciones();
        boolean bandera = false;
        ESTUDIANTE_DISENO estudianteNuevo = new ESTUDIANTE_DISENO(null, null, null, null, null, 0, null);
        TABLETA_GRAFICA tableta = new TABLETA_GRAFICA(null, null, 0, 0, null, 0, 0);
        for (TABLETA_GRAFICA tableta_GRAFICA : listaTabletas) {

            if (estudianteDiseno.getKey() == tableta_GRAFICA.getKey()) {
                System.out.println("¿Estas seguro que quieres modificar este prestamo?\n"
                        + "1. SI\n"
                        + "2. NO");

                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        break;
                    case 2:
                        return null;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

                estudianteDiseno.setKey(0);
                estudianteDiseno.setPrestamo(false);
                tableta = tableta_GRAFICA;
                bandera = true;
                System.out.println("");
                break;
            } else {
                System.out.println("Este estudiante no tiene ningun equipo asociado");
                break;
            }
        }

        if (bandera) {

            estudianteNuevo = accion.idEstudiante_DISENO(listaDisenos);
            estudianteNuevo.setKey(tableta.getKey());
            estudianteNuevo.setPrestamo(true);
            System.out.println("---MODIFICACÓN EXITOSA---\n");
        }
        return null;
    }

    public LinkedList<TABLETA_GRAFICA> modificarPrestamoDiseñador(LinkedList<ESTUDIANTE_DISENO> listaDisenos,
            LinkedList<TABLETA_GRAFICA> listaTabletas) {

        return null;
    }

    public boolean devolucionComputador(ESTUDIANTE_INGENIERIA estudiante,
            LinkedList<COMPUTADOR_PORTATIL> listaComputadores) {

        boolean bandera = false;

        for (COMPUTADOR_PORTATIL computador_PORTATIL : listaComputadores) {

            if (estudiante.getKey() == computador_PORTATIL.getKey()) {
                System.out.println("¿Estas seguro que quieres devolver este equipo?\n"
                        + "1. SI\n"
                        + "2. NO");

                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        break;
                    case 2:
                        return false;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
                estudiante.setKey(0);
                estudiante.setPrestamo(false);
                computador_PORTATIL.setDisponible(true);

                System.out.println("El computador con serial " + computador_PORTATIL.getSerial()
                        + " a nombre del estudiante "
                        + estudiante.getNombre() + " " + estudiante.getApellido() + " ha sido devuelto exitosamemte.");
                System.out.println("--------------------------------");
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            System.out.println("Este estudiante no tiene ningún préstamo activo\n");
            return false;
        }

        return true;
    }

    public boolean devolucionTableta(ESTUDIANTE_DISENO estudiante, LinkedList<TABLETA_GRAFICA> listaTabletas) {

        boolean bandera = false;

        for (TABLETA_GRAFICA tableta_GRAFICA : listaTabletas) {

            if (estudiante.getKey() == tableta_GRAFICA.getKey()) {
                System.out.println("¿Estas seguro que quieres devolver este equipo?\n"
                        + "1. SI\n"
                        + "2. NO");

                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        break;
                    case 2:
                        return false;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
                estudiante.setKey(0);
                estudiante.setPrestamo(false);
                tableta_GRAFICA.setDisponible(true);

                System.out.println("La tableta con serial " + tableta_GRAFICA.getSerial()
                        + " a nombre del estudiante "
                        + estudiante.getNombre() + " " + estudiante.getApellido() + " ha sido devuelta exitosamemte.");
                System.out.println("--------------------------------");
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            System.out.println("Este estudiante no tiene ningún préstamo activo\n");
            return false;
        }
        return true;
    }

    public void buscarComputador(ESTUDIANTE_INGENIERIA estudiante, LinkedList<COMPUTADOR_PORTATIL> listaComputadores) {

        boolean bandera = false;

        for (COMPUTADOR_PORTATIL computador : listaComputadores) {
            if (estudiante.getKey() == computador.getKey()) {

                System.out.println(
                        "Computador con serial " + computador.getSerial() + " a nombre de: " + estudiante.getNombre()
                                + " " + estudiante.getApellido());

                System.out.println("Serial: " + computador.getSerial());
                System.out.println("Marca: " + computador.getMarca());
                System.out.println("Tamaño: " + computador.getTamaño());
                System.out.println("Precio: " + computador.getPrecio());
                System.out.println("Sistema Operativo: " + computador.getSistemaOp());
                System.out.println("Procesador: " + computador.getProcesador());
                System.out.println("-------------------------------------------");
                bandera = true;
            }
        }

        if (!bandera) {
            System.out.println("Este estudiante no tiene ningún préstamo activo\n");
        }
    }

    public void buscarTableta(ESTUDIANTE_DISENO estudiante, LinkedList<TABLETA_GRAFICA> listaTabletas) {

        boolean bandera = false;

        for (TABLETA_GRAFICA tableta : listaTabletas) {
            if (estudiante.getKey() == tableta.getKey()) {
                System.out
                        .println("Tableta con serial " + tableta.getSerial() + " a nombre de: " + estudiante.getNombre()
                                + " " + estudiante.getApellido());

                System.out.println("Serial: " + tableta.getSerial());
                System.out.println("Marca: " + tableta.getMarca());
                System.out.println("Tamaño: " + tableta.getTamaño());
                System.out.println("Precio: " + tableta.getPrecio());
                System.out.println("Almacenamiento: " + tableta.getAlmacenamiento());
                System.out.println("Peso: " + tableta.getPeso() + "Kg");
                System.out.println("-------------------------------------------");
                bandera = true;
            }
        }

        if (!bandera) {
            System.out.println("Este estudiante no tiene ningún préstamo activo\n");
        }
    }
}
