package Empresa;

public class Empresa {
    
    // atributos da classe
    private int id;
    private String Nome;
    private String Sobrenome;
    private String Rg;
    private String Cpf;
    private String Atuacao;

    public Empresa() {
} 
    // Gets e Setters
    public void setAtuacao(String Atuacao) {
        this.Atuacao = Atuacao;
    }

    public String getAtuacao() {
        return Atuacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public String getRg() {
        return Rg;
    }

    public String getCpf() {
        return Cpf;
    }
}
