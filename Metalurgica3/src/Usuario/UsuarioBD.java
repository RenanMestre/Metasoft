package Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioBD {
    public static Usuario validarUsuarioSeguro(Usuario usuario) {
     // Criando consulta parametrizada
     String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
     Usuario usuarioEncontrado = null;

    try {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/metasoft", "root", "");
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        // Valores na consulta
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        ResultSet rs = statement.executeQuery();


        while (rs.next()) {
             usuarioEncontrado = new Usuario();
             usuarioEncontrado.setId(rs.getInt("id"));
             usuarioEncontrado.setNome(rs.getString("nome"));
             usuarioEncontrado.setEmail(rs.getString("email"));
             usuarioEncontrado.setSenha(rs.getString("senha"));
             usuarioEncontrado.setTipo(rs.getString("tipo"));
        }
     } catch (SQLException ex) {
         System.out.println("Sintaxe de comando invalida");
     }

     return usuarioEncontrado;
    }
}