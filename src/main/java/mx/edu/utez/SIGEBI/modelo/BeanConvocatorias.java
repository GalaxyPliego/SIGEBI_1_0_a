package mx.edu.utez.SIGEBI.modelo;

public class BeanConvocatorias {

    private int idConvocatoria;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private int idBeca;
    private int idAdministrador;
    private int idUsuario;
    private String nombre;
    private String primer;
    private String segundo;
    private String correo;
    private String clave;
    private int idDivision;
    private int tiporol;
    private String tipoBeca;
    private String estado2;
    private int idBeca2;

    //Metodos constructor vacío por regla general para los Bean
    public BeanConvocatorias() {
    }

    //Metodo para ELIMINAR una carrera con el id
    public BeanConvocatorias(int idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    //Metodo para CREAR
    public BeanConvocatorias(String fechaInicio, String fechaFin, String estado, int idBeca2, int idUsuario) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.idBeca2 = idBeca2;
        this.idUsuario = idUsuario;
    }

    //Metodo para ACTUALIZAR una carrera

    public BeanConvocatorias(int idConvocatoria, String fechaInicio, String fechaFin, String estado, int idBeca2, int idUsuario) {
        this.idConvocatoria = idConvocatoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.idBeca2 = idBeca2;
        this.idUsuario = idUsuario;
    }

    public int getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(int idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdBeca() {
        return idBeca;
    }

    public void setIdBeca(int idBeca) {
        this.idBeca = idBeca;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return "BeanConvocatorias{" +
                "idConvocatoria=" + idConvocatoria +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", estado='" + estado + '\'' +
                ", idBeca2=" + idBeca2 +
                ", idUsuario=" + idUsuario +
                '}';
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrimer(String primer) {
        this.primer = primer;
    }

    public String getPrimer() {
        return primer;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setTiporol(int tiporol) {
        this.tiporol = tiporol;
    }

    public int getTiporol() {
        return tiporol;
    }


    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setIdBeca2(int idBeca2) {
        this.idBeca2 = idBeca2;
    }

    public int getIdBeca2() {
        return idBeca2;
    }
}
