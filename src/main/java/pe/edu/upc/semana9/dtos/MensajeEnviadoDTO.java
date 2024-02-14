package pe.edu.upc.semana9.dtos;

public class MensajeEnviadoDTO {
    private String nombre_receptor;
    private String descripcion;

    public MensajeEnviadoDTO() {
    }

    public MensajeEnviadoDTO(String nombre_receptor, String descripcion) {
        this.nombre_receptor = nombre_receptor;
        this.descripcion = descripcion;
    }

    public String getNombre_receptor() {
        return nombre_receptor;
    }

    public void setNombre_receptor(String nombre_receptor) {
        this.nombre_receptor = nombre_receptor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
