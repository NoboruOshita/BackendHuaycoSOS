package pe.edu.upc.semana9.dtos;

public class UsuarioByDonacionDTO {
    private int idUsuario;
    private  int count;

    public UsuarioByDonacionDTO() {
    }

    public UsuarioByDonacionDTO(int idUsuario, int count) {
        this.idUsuario = idUsuario;
        this.count = count;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
