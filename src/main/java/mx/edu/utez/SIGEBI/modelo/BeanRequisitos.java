package mx.edu.utez.SIGEBI.modelo;

import java.sql.Blob;

public class BeanRequisitos {
    private int idRequisitos;
    private int CuatrimestreAnterior;
    private int CuatrimestreActual;
    private int promedio;
    private String motivos;
    private int tipo_beca;
    private int id_solicitud;
    private Blob boleta;

    public Blob getBoleta() {
        return boleta;
    }

    public void setBoleta(Blob boleta) {
        this.boleta = boleta;
    }

    public BeanRequisitos(){

    }

    public int getIdRequisitos() {
        return idRequisitos;
    }

    public void setIdRequisitos(int idRequisitos) {
        this.idRequisitos = idRequisitos;
    }

    public int getCuatrimestreAnterior() {
        return CuatrimestreAnterior;
    }

    public void setCuatrimestreAnterior(int cuatrimestreAnterior) {
        CuatrimestreAnterior = cuatrimestreAnterior;
    }

    public int getCuatrimestreActual() {
        return CuatrimestreActual;
    }

    public void setCuatrimestreActual(int cuatrimestreActual) {
        CuatrimestreActual = cuatrimestreActual;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    public int getTipo_beca() {
        return tipo_beca;
    }

    public void setTipo_beca(int tipo_beca) {
        this.tipo_beca = tipo_beca;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }
}
