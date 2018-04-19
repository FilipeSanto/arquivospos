/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author Filipe
 */
public abstract class AbstractDAO<T, I> implements DAO<T, I> {

    protected Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

}
