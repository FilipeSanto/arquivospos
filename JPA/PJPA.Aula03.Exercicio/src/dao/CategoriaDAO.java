/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class CategoriaDAO extends AbstractDAO<Categoria, Integer> {

    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public Categoria insert(Categoria t) throws SQLException {
        PreparedStatement statement = null;
        String sql = "insert into categoria (id, precoBase, descricao) values (?,?,?)";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, t.getIdCategoria());
            statement.setDouble(2, t.getPrecoBase());
            statement.setString(3, t.getDescricao());
            boolean retorno = statement.execute();
            return t;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e2) {
                System.err.println("Impossivel fechar comando " + e2);
            }
        }
    }

    @Override
    public int remove(Integer i) throws SQLException {
        PreparedStatement statement = null;
        String sql = "delete from categoria where id = ?";
        try {
            statement = conexao.prepareStatement(sql);
            boolean retorno = statement.execute();
            if (retorno) {
                return 1;
            } else {
                return 0;
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e2) {
                System.err.println("Impossivel fechar comando " + e2);
            }
        }
    }

    @Override
    public int update(Categoria t) throws SQLException {
        PreparedStatement statement = null;
        String sql = "Update categoria set preco_base = ?, descricao = ? where codigo = ?";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, t.getIdCategoria());
            statement.setDouble(2, t.getPrecoBase());
            statement.setString(3, t.getDescricao());
            boolean retorno = statement.execute();
            if (retorno) {
                return 1;
            } else {
                return 0;
            }

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e2) {
                System.err.println("Impossivel fechar comando " + e2);
            }
        }
    }

    @Override
    public Categoria findById(Integer i) throws SQLException {
        PreparedStatement statement = null;
        Categoria categoria = new Categoria();

        String sql = "SELECT id_categoria, preco_base, descricao FROM categoria where id_categoria = ?";

        try {
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, i);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("id_categoria"), rs.getDouble("preco_base"), rs.getString("descricao"));
            }

            return categoria;

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e2) {
                System.err.println("Impossivel fechar comando " + e2);
            }
        }
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        PreparedStatement statement = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "select * from Categoria";
        try {
            statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                double precoBase = rs.getDouble("preco_base");
                String descricao = rs.getString("descricao");
                Categoria categoria = new Categoria(idCategoria, precoBase, descricao);
                categorias.add(categoria);
                
            }
            return categorias;

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e2) {
                System.err.println("Impossivel fechar comando " + e2);
            }
        }
    }

}
