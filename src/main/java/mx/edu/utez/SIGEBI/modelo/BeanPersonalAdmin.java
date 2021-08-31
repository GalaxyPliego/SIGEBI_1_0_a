package mx.edu.utez.SIGEBI.modelo;

public class BeanPersonalAdmin {
    private int id_personalAdmin;
    private String parentesco;
    private String nombre_completoFamiliar;
    private String area_trabajo;
    private String trabajador;

    public BeanPersonalAdmin() {
    }

    public int getId_personalAdmin() {
        return id_personalAdmin;
    }

    public void setId_personalAdmin(int id_personalAdmin) {
        this.id_personalAdmin = id_personalAdmin;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNombre_completoFamiliar() {
        return nombre_completoFamiliar;
    }

    public void setNombre_completoFamiliar(String nombre_completoFamiliar) {
        this.nombre_completoFamiliar = nombre_completoFamiliar;
    }

    public String getArea_trabajo() {
        return area_trabajo;
    }

    public void setArea_trabajo(String area_trabajo) {
        this.area_trabajo = area_trabajo;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
}
