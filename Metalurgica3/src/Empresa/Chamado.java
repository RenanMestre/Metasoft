package Empresa;

public class Chamado {
    
    // Atributos da classe
    private int id;
    private String Solicitante;
    private String Setor;
    private String Problema;
    
    public Chamado() {
} 
    // Gets e Setters
    public void setProblema(String Problema) {
        this.Problema = Problema;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getProblema() {
        return Problema;
    }

    public void setSolicitante(String Solicitante) {
        this.Solicitante = Solicitante;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public String getSolicitante() {
        return Solicitante;
    }

    public String getSetor() {
        return Setor;
    }
    
}
