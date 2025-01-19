package Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleDAO {
    private Connection conn;

    // Construtor
    public ControleDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (SQLException e) {
            // Mensagem de erro se não conseguir conectar
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Recuperação dos dados
    public ArrayList<Controle> getControle() {
        String sql = "SELECT * FROM controle";
        ArrayList<Controle> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Controle controle = new Controle(); 
                controle.setId(rs.getInt("id")); // ID
                controle.setNome(rs.getString("nome")); // Nome
                controle.setSobrenome(rs.getString("sobrenome")); // Sobrenome
                controle.setHora(rs.getString("hora")); // Hora
                controle.setOcupacao(rs.getString("ocupacao")); // Ocupação
                
                lista.add(controle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     // Salvando os dados no banco de dados
    public int salvar(Controle controle) {
        String sql = "INSERT INTO controle (nome, sobrenome, hora, ocupacao) VALUES (?, ?, ?, ?)";
        Connection conn = Conexao.conectar();

        if (conn == null) {
            System.out.println("Erro: Conexão com o banco falhou.");
            return -1;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, controle.getNome()); // Salvando o nome
            stmt.setString(2, controle.getSobrenome()); // Salvando o sobrenome
            stmt.setString(3, controle.getHora()); // Salvando a hora
            stmt.setString(4, controle.getOcupacao()); // Salvando a ocupação

            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry")) {
                return 1062; 
            }
            System.err.println("Erro ao salvar dados: " + e.getMessage());
            return -1;
        } finally {
            Conexao.desconectar(conn);
        }
    }
}