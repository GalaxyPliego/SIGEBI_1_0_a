package mx.edu.utez.SIGEBI.modelo;

public class BeanUsuarios {

    private int idUsuario;
    private String correo;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String clave;
    private String estado;
    private int rol;
    private int idDivisionAcademica;

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public BeanUsuarios(){
    }

    public BeanUsuarios(int idUsuario, String nombre, String primerApellido, String segundoApellido,String correo, String clave) {
        BeanAlumnos unAlumno = new BeanAlumnos();
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.clave = clave;
        this.idDivisionAcademica = idDivisionAcademica;
    }


    //Metodo para ELIMINAR un usuario con el id
    public BeanUsuarios(int idUsuario){
        this.idUsuario = idUsuario;
    }

    //Metodo para ACTUALIZAR un nuevo usuario
    public BeanUsuarios(int idUsuario, String correo, String nombre, String primerApellido, String segundoApellido, String clave, String estado, int rol, int idDivisionAcademica) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.idDivisionAcademica = idDivisionAcademica;
    }

    //Método para CREAR nuevo usuario
    public BeanUsuarios(String correo, String nombre, String primerApellido, String segundoApellido, String clave, String estado, int rol, int idDivisionAcademica) {
        this.correo = correo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.idDivisionAcademica = idDivisionAcademica;
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



    public void setPrimerApeliido(String primerApeliido) {
        this.primerApellido = primerApeliido;
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




}
