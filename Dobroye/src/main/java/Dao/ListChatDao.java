package Dao;

import Connection.Database;
import Interface.ListChatController;
import Model.ListChat;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListChatDao implements ListChatController {

    @Override
    public List<ListChat> Lista(int idChat) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ListChat> lista = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM listachat WHERE ID_CHAT LIKE ? ORDER BY DATA");
            stmt.setInt(1, idChat);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListChat l = new ListChat() {
                };

                l.setId(rs.getInt("ID"));
                l.setIdChat(rs.getInt("ID_CHAT"));
                l.setIdUsuario(rs.getInt("ID_USUARIO"));
                l.setTextp(rs.getString("TEXTO"));
                l.setData(rs.getDate("DATA"));

                lista.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return lista;
    }

    @Override
    public boolean salvar(ListChat c) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        boolean resultado;
        try {
            stmt = connection.prepareStatement("INSERT INTO listachat(ID_CHAT, ID_USUARIO, TEXTO, DATA) VALUES (?,?,?,?);");
            stmt.setInt(1, c.getIdChat());
            stmt.setInt(2, c.getIdUsuario());
            stmt.setString(3, c.getTextp());
            stmt.setDate(4, c.getData());

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
    public int idPrincial(int id, int i) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int resultado = 0;

        try {
            stmt = connection.prepareStatement("SELECT * FROM listachat WHERE ID_USUARIO LIKE ? AND ID_CHAT LIKE ?;");
            stmt.setInt(1, id);
            stmt.setInt(2, i);

            rs = stmt.executeQuery();

            while (rs.next()) {
                resultado = id;
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return resultado;
    }
}
