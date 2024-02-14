package pe.edu.upc.semana9.dtos;

public class departamentoxDonacionDTO {
    private String departamento;
    private int contador;

    public departamentoxDonacionDTO() {
    }

    public departamentoxDonacionDTO(String departamento, int contador) {
        this.departamento = departamento;
        this.contador = contador;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
