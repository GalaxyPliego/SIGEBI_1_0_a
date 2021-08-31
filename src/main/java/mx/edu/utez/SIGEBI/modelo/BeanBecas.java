package mx.edu.utez.SIGEBI.modelo;

public class BeanBecas {

    private int idBeca;
    private String tipoBeca;
    private String estado;

    public BeanBecas(){
    }

    public BeanBecas(int idBeca, String tipoBeca, String estado) {
        this.idBeca = idBeca;
        this.tipoBeca = tipoBeca;
        this.estado = estado;
    }

    public int getIdBeca() {
        return idBeca;
    }

    public void setIdBeca(int idBeca) {
        this.idBeca = idBeca;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
