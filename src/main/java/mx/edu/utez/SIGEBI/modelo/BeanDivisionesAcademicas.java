package mx.edu.utez.SIGEBI.modelo;

public class BeanDivisionesAcademicas {

    private int idDivisionAcademica;
    private String nombreDivisionAcademica;
    private String estado;

    /*
     * //Metodo constructor vacío//
     * Por regla general, para que una clase java sea Bean, debe de tener un metodo constructor vacío
     * */
    public BeanDivisionesAcademicas(){
    }

    /*
    * //Metodo constructor para ELIMINAR elementos de la tabla//
    Este método de sobrecarga se utiliza para eliminar datos de la tabla; solo se utiliza el id ya que al hacer la sentencia
    * SQL para eliminar solo se necesita un id
    * */
    public BeanDivisionesAcademicas(int idDivisionAcademica){
        this.idDivisionAcademica = idDivisionAcademica;
    }

    /*
    * //Se utiliza para AGREGAR O CREAR una nueva division academica//
    * Este metodo contructor, tambien llamado como metodo constructor sobrecargado, tiene como finalidad mandarse a llamar
    * para agregar una nueva division en la base de datos.
    * Se mandan a llamar todos los datos menos el id, ya que ese por defecto la base de datos lo autoincrementa
    * */
    public BeanDivisionesAcademicas(String nombreDivisionAcademica, String estado) {
        this.nombreDivisionAcademica = nombreDivisionAcademica;
        this.estado = estado;
    }

    /*
    * //Metodo para ACTUALIZAR los datos de la base//
    * Este metodo constructo tiene la finalidad de actualizar todos los datos de la tabla, es por eso que se le pasan
    * los parametros completos para que puedan ser editados
    * */
    public BeanDivisionesAcademicas(int idDivisionAcademica, String nombreDivisionAcademica, String estado) {
        this.idDivisionAcademica = idDivisionAcademica;
        this.nombreDivisionAcademica = nombreDivisionAcademica;
        this.estado = estado;
    }


    public int getIdDivisionAcademica() {
        return idDivisionAcademica;
    }

    public void setIdDivisionAcademica(int idDivisionAcademica) {
        this.idDivisionAcademica = idDivisionAcademica;
    }

    public String getNombreDivisionAcademica() {
        return nombreDivisionAcademica;
    }

    public void setNombreDivisionAcademica(String nombreDivisionAcademica) {
        this.nombreDivisionAcademica = nombreDivisionAcademica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    }
