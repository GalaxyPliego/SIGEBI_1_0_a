package mx.edu.utez.SIGEBI.modelo;

import java.sql.Blob;

public class BeanMadresSolteras {
    private int id_madresSolteras;
    private Blob acta_nacimientoMadre;
    private  Blob acta_nacimientoHijo;

    public BeanMadresSolteras() {

    }

    public int getId_madresSolteras() {
        return id_madresSolteras;
    }

    public void setId_madresSolteras(int id_madresSolteras) {
        this.id_madresSolteras = id_madresSolteras;
    }

    public Blob getActa_nacimientoMadre() {
        return acta_nacimientoMadre;
    }

    public void setActa_nacimientoMadre(Blob acta_nacimientoMadre) {
        this.acta_nacimientoMadre = acta_nacimientoMadre;
    }

    public Blob getActa_nacimientoHijo() {
        return acta_nacimientoHijo;
    }

    public void setActa_nacimientoHijo(Blob acta_nacimientoHijo) {
        this.acta_nacimientoHijo = acta_nacimientoHijo;
    }
}
