/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJPA.Aula02.Ex02;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Filipe
 */
public class DAOFactory {

    public static DAO<Aluno, Integer> getAlunoDAO(Connection conexao)
            throws SQLException {
        return new AlunoDAO(conexao);
    }

//    public static DAO<Produto, Integer> getProdutoDAO(Connection conexao)
//            throws SQLException {
//        return new ProdutoDAO(conexao);
//    }
}
