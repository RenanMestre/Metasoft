package Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO {
    private Connection conn;

    // Construtor
    public EmpresaDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (SQLException e) {
            // Mensagem de erro se não conseguir conectar
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Recuperação dos dados
    public ArrayList<Empresa> getEmpresa() {
        String sql = "SELECT * FROM funcionarios";
        ArrayList<Empresa> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = new Empresa(); 
                empresa.setId(rs.getInt("id")); // ID
                empresa.setNome(rs.getString("nome")); // Nome
                empresa.setSobrenome(rs.getString("sobrenome")); // Sobrenome
                empresa.setRg(rs.getString("rg")); // RG
                empresa.setCpf(rs.getString("cpf")); // CPF
                empresa.setAtuacao(rs.getString("atuacao")); // Atuação
                
                lista.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     // Salvando os dados no banco de dados
    public int salvar(Empresa empresa) {
        String sql = "INSERT INTO funcionarios (nome, sobrenome, rg, cpf, atuacao) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Conexao.conectar();

        if (conn == null) {
            System.out.println("Erro: Conexão com o banco falhou.");
            return -1;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome()); // Salvando o nome
            stmt.setString(2, empresa.getSobrenome()); // Salvando o sobrenome
            stmt.setString(3, empresa.getRg()); // Salvando o RG
            stmt.setString(4, empresa.getCpf()); // Salvando o CPF
            stmt.setString(5, empresa.getAtuacao()); // Salvando a atuação

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
    
    // Excluir o filme    
    public boolean excluirDados(int idEmpresa) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa); // ID do funcionário a ser excluído
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; 
            // Não encontrou o funcionário para excluir
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Caso ocorra algum erro
        }
    }
}