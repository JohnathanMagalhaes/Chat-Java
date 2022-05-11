package Dao;

import Connection.Database;
import Interface.ChatController;
import Model.Chat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatDao implements ChatController {

    @Override
    public boolean salvar(Chat c) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        boolean resultado;
        try {
            stmt = connection.prepareStatement("INSERT INTO chat(ID_USUARIO_P, ID_USUARIO_S) VALUES (?,?);");
            stmt.setInt(1, c.getIdUsuarioP());
            stmt.setInt(2, c.getIdUsuarioS());

            stmt.executeUpdate();
            resultado = true;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            resultado = false;
        } finally {
            Database.closeConnection(connection, stmt);
        }
        return resultado;
    }

    @Override
    public Chat consulta(int p, int s) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Chat c = new Chat();

        try {
            stmt = connection.prepareStatement("SELECT * FROM chat WHERE ID_USUARIO_P LIKE ? AND ID_USUARIO_S LIKE ? OR ID_USUARIO_S LIKE ? AND ID_USUARIO_P LIKE ?;");
            stmt.setInt(1, p);
            stmt.setInt(2, s);
            stmt.setInt(3, p);
            stmt.setInt(4, s);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt("ID"));
                c.setIdUsuarioP(rs.getInt("ID_USUARIO_P"));
                c.setIdUsuarioS(rs.getInt("ID_USUARIO_S"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return c;
    }

    @Override
    public boolean verificarExiste(int p, int s) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean resultado = false;

        try {
            stmt = connection.prepareStatement("SELECT * FROM chat WHERE ID_USUARIO_P LIKE ? AND ID_USUARIO_S LIKE ? OR ID_USUARIO_S LIKE ? AND ID_USUARIO_P LIKE ?;");
            stmt.setInt(1, p);
            stmt.setInt(2, s);
            stmt.setInt(3, p);
            stmt.setInt(4, s);

            rs = stmt.executeQuery();

            while (rs.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return resultado;
    }
}
