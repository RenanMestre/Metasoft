package Empresa;

public class Controle {
 
       // atributos da classe
    private int id;
    private String Nome;
    private String Sobrenome;
    private String Hora;    
    private String Ocupacao;
    

    public Controle() {
} 
    // Gets e Setters

    public void setOcupacao(String Ocupacao) {
        this.Ocupacao = Ocupacao;
    }

    public String getOcupacao() {
        return Ocupacao;
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

    public void setHora(String Hora) {
        this.Hora = Hora;
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

    public String getHora() {
        return Hora;
    }
    
}
