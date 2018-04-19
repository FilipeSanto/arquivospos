/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJPA.Aula02.Ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author Filipe
 */
public class AlunoDAO extends AbstractDAO<Aluno, Integer> {

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public boolean insert(Aluno aluno) throws SQLException {

        PreparedStatement statement = null;

        String sql = "insert into Alunos (matricula, nome) values (?, ?)";
        try {

            statement = conexao.prepareStatement(sql);
            statement.setInt(1, aluno.getMatricula());            
            statement.setString(2, aluno.getNome());
            return statement.executeUpdate() > 0;
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
    public boolean remove(Integer i) throws SQLException {
        PreparedStatement statement = null;
        String sql = "delete from Alunos where matricula = ?";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, i);
            return statement.executeUpdate() > 0;

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
    public boolean update(Aluno aluno) throws SQLException {
        PreparedStatement statement = null;
        String sql = "Update Alunos set nome = ? where matricula = ?";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            return statement.executeUpdate() > 0;
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
    public Aluno getById(Integer i) throws SQLException {
        PreparedStatement statement = null;
        Aluno aluno = new Aluno();

        String sql = "SELECT matricula, nome FROM Alunos where matricula = ?";

        try {
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, i);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                aluno = new Aluno(rs.getInt("matricula"), rs.getString("nome"));
            }

            return aluno;

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
    public List<Aluno> findAll() throws SQLException {
        PreparedStatement statement = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "select * from Alunos";
        try {
            statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                Aluno aluno = new Aluno(matricula, nome);
                alunos.add(aluno);
            }
            return alunos;

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
