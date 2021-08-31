
package mx.edu.utez.SIGEBI.modelo;

import java.sql.Blob;

public class BeanDiscapacidad {
    private int id_disComInd;
    private Blob constancia;

    public BeanDiscapacidad(){

    }

    public int getId_disComInd() {
        return id_disComInd;
    }

    public void setId_disComInd(int id_disComInd) {
        this.id_disComInd = id_disComInd;
    }

    public Blob getConstancia() {
        return constancia;
    }

    public void setConstancia(Blob constancia) {
        this.constancia = constancia;
    }
}