public class ESTUDIANTE_DISENO {

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String modalidad;
    int asignaturas;
    String serial;
    boolean prestamo;
    int key;

    public ESTUDIANTE_DISENO(String cedula, String nombre, String apellido, String telefono, String modalidad,
            int asignaturas, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidad = modalidad;
        this.asignaturas = asignaturas;
        this.serial = serial;
        this.prestamo = false;
        this.key = 0;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
