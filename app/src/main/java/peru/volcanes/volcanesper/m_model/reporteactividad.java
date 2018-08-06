package peru.volcanes.volcanesper.m_model;
public class reporteactividad {
    String codigovolcan;
    String fecha;
    String hora;
    String horautc;
    String pdfurl;
    String simulacro;
    String tipodevento;
    String tiponotificacion;
    String nombrereporte;

    public String getCodigovolcan() {
        return codigovolcan;
    }

    public void setCodigovolcan(String codigovolcan) {
        this.codigovolcan = codigovolcan;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHorautc() {
        return horautc;
    }

    public void setHorautc(String horautc) {
        this.horautc = horautc;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }

    public String getSimulacro() {
        return simulacro;
    }

    public void setSimulacro(String simulacro) {
        this.simulacro = simulacro;
    }

    public String getTipodevento() {
        return tipodevento;
    }

    public void setTipodevento(String tipodevento) {
        this.tipodevento = tipodevento;
    }

    public String getTiponotificacion() {
        return tiponotificacion;
    }

    public void setTiponotificacion(String tiponotificacion) {
        this.tiponotificacion = tiponotificacion;
    }

    public String getNombrereporte() {
        return nombrereporte;
    }

    public void setNombrereporte(String nombrereporte) {
        this.nombrereporte = nombrereporte;
    }


    public reporteactividad(String codigovolcan, String fecha, String hora, String horautc, String pdfurl, String simulacro, String tipodevento, String tiponotificacion, String nombrereporte) {
        this.codigovolcan = codigovolcan;
        this.fecha = fecha;
        this.hora = hora;
        this.horautc = horautc;
        this.pdfurl = pdfurl;
        this.simulacro = simulacro;
        this.tipodevento = tipodevento;
        this.tiponotificacion = tiponotificacion;
        this.nombrereporte = nombrereporte;
    }

    public reporteactividad() {
    }
}
