public class ESTUDIANTE_INGENIERIA {

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    int semestre;
    float promedio;
    String serial;
    boolean prestamo;
    int key;

    public ESTUDIANTE_INGENIERIA(String cedula, String nombre, String apellido, String telefono, int semestre,
            float promedio, String serial, int key) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.semestre = semestre;
        this.promedio = promedio;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
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