package mx.edu.utez.SIGEBI.modelo;

public class BeanCarreras {

    private int idCarrera;
    private String nombreCarrera;
    private String estado;
    private int idDivisionAcademica;

     //Metodo constructor vacío por regla general de los bean
    public BeanCarreras(){
    }

    //Metodo para ELIMINAR una carrera con el id
    public BeanCarreras(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    //Metodo para CREAR una carrera
    public BeanCarreras(String nombreCarrera, String estado, int idDivisionAcademica) {
        this.nombreCarrera = nombreCarrera;
        this.estado = estado;
        this.idDivisionAcademica = idDivisionAcademica;
    }

    //Metodo para ACTUALIZAR una carrera
    public BeanCarreras(int idCarrera, String nombreCarrera, String estado, int idDivisionAcademica) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.estado = estado;
        this.idDivisionAcademica = idDivisionAcademica;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdDivisionAcademica() {
        return idDivisionAcademica;
    }

    public void setIdDivisionAcademica(int idDivisionAcademica) {
        this.idDivisionAcademica = idDivisionAcademica;
    }

    @Override
    public String toString() {
        return "BeanCarreras{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", estado='" + estado + '\'' +
                ", idDivisionAcademica=" + idDivisionAcademica +
                '}';
    }
}
