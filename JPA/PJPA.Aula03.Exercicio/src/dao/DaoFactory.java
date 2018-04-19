/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Avaria;
import classes.Categoria;
import classes.Cliente;
import classes.Funcionario;
import classes.Locacao;
import classes.Multa;
import classes.Veiculo;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Filipe
 */
public class DaoFactory {

    public static DAO<Cliente, Integer> getClienteDAO(Connection conexao) throws SQLException {
        return new ClienteDAO(conexao);
    }

    public static DAO<Veiculo, Integer> getVeiculoDAO(Connection conexao) throws SQLException {
        return new VeiculoDAO(conexao);
    }

    public static DAO<Locacao, Integer> getLocacaoDAO(Connection conexao) throws SQLException {
        return new LocacaoDAO(conexao);
    }

    public static DAO<Funcionario, Integer> getFuncionarioDAO(Connection conexao) throws SQLException {
        return new FuncionarioDAO(conexao);
    }

    public static DAO<Categoria, Integer> getCategoriaDAO(Connection conexao) throws SQLException {
        return new CategoriaDAO(conexao);
    }

    public static DAO<Avaria, Integer> getAvariaDAO(Connection conexao) throws SQLException {
        return new AvariaDAO(conexao);
    }

    public static DAO<Multa, Integer> getMultaDAO(Connection conexao) throws SQLException {
        return new MultaDAO(conexao);
    }

}
