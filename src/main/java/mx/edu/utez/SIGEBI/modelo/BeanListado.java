package mx.edu.utez.SIGEBI.modelo;

public class BeanListado {
    private  int id_solicitud;
    private  String fechaSolicitud;
    private String estado;
    private String comentario;
    private String verdicto;
    private int porcentaje;
    private  String matriculaSolicitud;
    private int convocatoria;
    private int  comite;
    private String nombre;


    public BeanListado(){
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getVerdicto() {
        return verdicto;
    }

    public void setVerdicto(String verdicto) {
        this.verdicto = verdicto;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getMatriculaSolicitud() {
        return matriculaSolicitud;
    }

    public void setMatriculaSolicitud(String matriculaSolicitud) {
        this.matriculaSolicitud = matriculaSolicitud;
    }

    public int getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(int convocatoria) {
        this.convocatoria = convocatoria;
    }

    public int getComite() {
        return comite;
    }

    public void setComite(int comite) {
        this.comite = comite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

