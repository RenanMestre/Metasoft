package Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoDAO {
    private Connection conn;

    // Construtor
    public ChamadoDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (SQLException e) {
            // Mensagem de erro se não conseguir conectar
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Recuperação dos dados
    public ArrayList<Chamado> getChamado() {
        String sql = "SELECT * FROM chamado";
        ArrayList<Chamado> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Chamado chamado = new Chamado(); 
                chamado.setSolicitante(rs.getString("solicitante")); // Solicitante
                chamado.setSetor(rs.getString("setor")); // Setor
                chamado.setProblema(rs.getString("problema")); // Problema
                
                lista.add(chamado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     // Salvando os dados no banco de dados
    public int salvar(Chamado chamado) {
        String sql = "INSERT INTO chamado (solicitante, setor, problema) VALUES (?, ?, ?)";
        Connection conn = Conexao.conectar();

        if (conn == null) {
            System.out.println("Erro: Conexão com o banco falhou.");
            return -1;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chamado.getSolicitante()); // Salvando o solicitante
            stmt.setString(2, chamado.getSetor()); // Salvando o setor
            stmt.setString(3, chamado.getProblema()); // Salvando o problema

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
