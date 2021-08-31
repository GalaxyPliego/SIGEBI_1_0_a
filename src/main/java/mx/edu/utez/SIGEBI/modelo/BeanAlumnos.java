package mx.edu.utez.SIGEBI.modelo;

public class BeanAlumnos {

    private int idAlumno;
    private String matricula;
    private String fechaNacimiento;
    private String telefono;
    private String celular;
    private String curp;
    private String nivelAcademico;
    private String turno;
    private String sexo;
    private String nacionalidad;
    private String colonia;
    private String numInterior;
    private String numExterior;
    private String entidadFederativa;
    private String delegacion;
    private String codigoPostal;
    private String calle;
    private int idCarrera;
    private int idDivisionAcademica;

    private String nombre;
    private String primerApellido;



    private String segundoApellido;
    private String correo;
    private String estado;
    private String nombreBeca;



    private String fecha_solicitud;
    private String veredicto;
    private String porcentaje;


    public String getNombreBeca() {
        return nombreBeca;
    }

    public void setNombreBeca(String nombreBeca) {
        this.nombreBeca = nombreBeca;
    }

    public BeanAlumnos(String fechaNacimiento, String telefono, String celular, String curp, String sexo, String nacionalidad, String colonia, String numInterior, String numExterior, String entidadFederativa, String delegacion, String codigoPostal, String calle, int idAlumno)
    {
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.colonia = colonia;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.entidadFederativa = entidadFederativa;
        this.delegacion = delegacion;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.idAlumno = idAlumno;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getVeredicto() {
        return veredicto;
    }

    public void setVeredicto(String veredicto) {
        this.veredicto = veredicto;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    //Metodo constructor vacío
    //Por regla general, para que una clase java sea Bean, debe de tener un metodo constructor vacío
    public BeanAlumnos() {
    }

    //Metodo para ELIMINAR alumnos//
    /* Este método de sobrecarga se utiliza para eliminar datos de la tabla; solo se utiliza el id ya que al hacer la sentencia
     * SQL para eliminar solo se necesita un id
     * */
    public BeanAlumnos(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    //Metodo para CREAR un nuevo alumno//
    /* Este metodo contructor, tambien llamado como metodo constructor sobrecargado, tiene como finalidad mandarse a llamar
     * para agregar una nuevo usuario en la base de datos.
     * Se mandan a llamar todos los datos menos el id, ya que por defecto la base de datos lo autoincrementa */
    public BeanAlumnos(String matricula, String fechaNacimiento, String telefono, String celular, String curp, String nivelAcademico, String turno, String sexo, String nacionalidad, String colonia, String numInterior, String numExterior, String entidadFederativa, String delegacion, String codigoPostal, String calle, int idDivisionAcademica, int idCarrera) {
        this.matricula = matricula;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.nivelAcademico = nivelAcademico;
        this.turno = turno;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.colonia = colonia;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.entidadFederativa = entidadFederativa;
        this.delegacion = delegacion;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.idDivisionAcademica = idDivisionAcademica;
        this.idCarrera = idCarrera;
    }

    public BeanAlumnos (int idAlumno, String estado){
        this.idAlumno = idAlumno;
        this.estado = estado;
    }

    //Metodo para ACTUALIZAR los datos de los alumnos
    /* Este metodo constructo tiene la finalidad de actualizar todos los datos de la tabla, es por eso que se le pasan
     * los parametros completos para que puedan ser editados */
    public BeanAlumnos(int idAlumno, String matricula, String fechaNacimiento, String telefono, String celular, String curp, String nivelAcademico, String turno, String sexo, String nacionalidad, String colonia, String numInterior, String numExterior, String entidadFederativa, String delegacion, String codigoPostal, String calle, int idDivisionAcademica, int idCarrera) {
        this.idAlumno = idAlumno;
        this.matricula = matricula;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.nivelAcademico = nivelAcademico;
        this.turno = turno;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.colonia = colonia;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.entidadFederativa = entidadFederativa;
        this.delegacion = delegacion;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.idDivisionAcademica = idDivisionAcademica;
        this.idCarrera = idCarrera;
    }

    //Todos los metodos Getters and Setters
    //Se utlizan para acceder a las variables, ya que estas son privadas
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getIdDivisionAcademica() {
        return idDivisionAcademica;
    }

    public void setIdDivisionAcademica(int idDivisionAcademica) {
        this.idDivisionAcademica = idDivisionAcademica;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}