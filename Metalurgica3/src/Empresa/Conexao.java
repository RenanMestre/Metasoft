package Empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Conexão com o banco de dados
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/metasoft";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
   
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Mensagem
            JOptionPane.showMessageDialog(null, "Não foi possível ter a conexão com o banco de dados");
            System.err.println("Ocorreu um erro na conexão do banco: " + e.getMessage() + " Por favor verifique o nome usuário e senha do banco de dados");
            return null;
        }
    }

    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                // Mensagem amigável
                System.out.println("Conexão encerrada com sucesso.");
            } catch (SQLException e) {
                // Mensagem amigável
                System.err.println("Erro ao encerrar conexão: " + e.getMessage() + " Por favor verifique o nome usuário e senha do banco de dados");
            }
        }
    }
}
