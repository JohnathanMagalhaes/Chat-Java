package Dao;

import Connection.Database;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.PessoaController;

public class PessoaDao implements PessoaController {

    @Override
    public boolean login(String email, String senha) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean resultado = false;

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE EMAIL LIKE ? AND SENHA LIKE ?;");
            stmt.setString(1, email);
            stmt.setString(2, senha);

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

    @Override
    public Pessoa consultaEmail(String email) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pessoa pessoa = new Pessoa();
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE EMAIL LIKE ?;");
            stmt.setString(1, "%" + email + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                pessoa.setIdUsuario(rs.getInt("ID"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setSenha(rs.getString("SENHA"));
                pessoa.setBiografia(rs.getString("BIOGRAFIA"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setImagem(rs.getBytes("IMAGEM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return pessoa;
    }

    @Override
    public Pessoa consultaNome(String nome) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pessoa pessoa = new Pessoa();

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE NOME LIKE ?;");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {

                pessoa.setIdUsuario(rs.getInt("ID"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setSenha(rs.getString("SENHA"));
                pessoa.setBiografia(rs.getString("BIOGRAFIA"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setImagem(rs.getBytes("IMAGEM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> Lista(String nome) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE NOME LIKE ? OR EMAIL LIKE ? ORDER BY NOME");
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setIdUsuario(rs.getInt("ID"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setSenha(rs.getString("SENHA"));
                pessoa.setBiografia(rs.getString("BIOGRAFIA"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setImagem(rs.getBytes("IMAGEM"));

                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return pessoas;
    }

    @Override
    public boolean salvar(Pessoa pessoa) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        boolean resultado;
        try {
            stmt = connection.prepareStatement("INSERT INTO usuario(NOME, EMAIL, SENHA, BIOGRAFIA, SEXO, IMAGEM) VALUES (?,?,?,?,?,?);");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(4, pessoa.getBiografia());
            stmt.setString(5, pessoa.getSexo());
            stmt.setBytes(6, pessoa.getImagem());
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
    public boolean Atualizar(Pessoa pessoa) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;

        boolean resultado;

        try {
            stmt = connection.prepareStatement("UPDATE usuario SET NOME = ?, EMAIL = ?, SENHA = ?, BIOGRAFIA = ?, SEXO = ?, IMAGEM = ? WHERE ID = ?");

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(4, pessoa.getBiografia());
            stmt.setString(5, pessoa.getSexo());
            stmt.setBytes(6, pessoa.getImagem());
            stmt.setInt(7, pessoa.getIdUsuario());
            stmt.executeUpdate();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            resultado = false;
        } finally {
            Database.closeConnection(connection, stmt);
        }
        return resultado;
    }

    @Override
    public Pessoa consultaID(int id) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pessoa pessoa = new Pessoa();

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE ID LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                pessoa.setIdUsuario(rs.getInt("ID"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setSenha(rs.getString("SENHA"));
                pessoa.setBiografia(rs.getString("BIOGRAFIA"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setImagem(rs.getBytes("IMAGEM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(connection, stmt, rs);
        }
        return pessoa;
    }

    @Override
    public boolean VerificarEmailExiste(String email) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean resultado = false;

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE EMAIL LIKE ?;");
            stmt.setString(1, email);

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
