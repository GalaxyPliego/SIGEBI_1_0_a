package mx.edu.utez.SIGEBI.modelo;

public class BeanComite {
    private int idUsuario;
    private String correo;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String clave;
    private String estado;
    private int rol;
    private int idDivisionAcademica;
    public String buscador;

    public BeanComite(){
    }

    public BeanComite(int  idUsuario, String nombre, String primerApellido, String segundoApellido, String correo, String clave, String estado, int idDivisionAcademica) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
        this.idDivisionAcademica = idDivisionAcademica;
    }
    public BeanComite(String buscador){
        this.buscador= buscador;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getIdDivisionAcademica() {
        return idDivisionAcademica;
    }

    public void setIdDivisionAcademica(int idDivisionAcademica) {
        this.idDivisionAcademica = idDivisionAcademica;
    }

    @Override
    public String toString() {
        return "BeanComite{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApeliido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", contrasenia='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                ", rol=" + rol +
                ", idDivisionAcademica=" + idDivisionAcademica +
                '}';
    }


}
