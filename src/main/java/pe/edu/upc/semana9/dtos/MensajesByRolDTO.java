package pe.edu.upc.semana9.dtos;

public class MensajesByRolDTO {
    private String role;
    private int mensajesCount;

    public MensajesByRolDTO() {
    }

    public MensajesByRolDTO(String role, int mensajesCount) {
        this.role = role;
        this.mensajesCount = mensajesCount;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMensajesCount() {
        return mensajesCount;
    }

    public void setMensajesCount(int mensajesCount) {
        this.mensajesCount = mensajesCount;
    }
}
