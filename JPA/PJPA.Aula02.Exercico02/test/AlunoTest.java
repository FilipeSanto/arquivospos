/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import PJPA.Aula02.Ex02.Aluno;
import PJPA.Aula02.Ex02.AlunoDAO;
import PJPA.Aula02.Ex02.ConnectionFactory;
import PJPA.Aula02.Ex02.DAO;
import PJPA.Aula02.Ex02.DAOFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.assertTrue;



/**
 *
 * @author Filipe
 */
public class AlunoTest {

    @Test
    public void insertAluno() {
        Connection conexao = null;
        boolean alunoSalvo = false;
        try {
            conexao = ConnectionFactory.getConnection();
            DAO<Aluno, Integer> alunoDAO = PJPA.Aula02.Ex02.DAOFactory.getAlunoDAO(conexao);
            Aluno alunoNovo = new Aluno(1233, "Filipe");
            alunoSalvo = alunoDAO.insert(alunoNovo);
//            conexao.commit();
        } catch (Exception e) {
            System.err.println(e);
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
            }
            Assert.fail("não consegui inserir Aluno");
        } finally {
            ConnectionFactory.closeConnection(conexao, null, null);
        }
        assertTrue(alunoSalvo);
    }

    @Test
    public void selecionaUmAluno() {
        Connection conexao = null;
        Aluno aluno = null;
        try {
            conexao = ConnectionFactory.getConnection();
            DAO<Aluno, Integer> AlunoDAO = PJPA.Aula02.Ex02.DAOFactory.getAlunoDAO(conexao);
            aluno = AlunoDAO.getById(1);
        } catch (Exception e) {
            System.err.println(e);
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
            }
            Assert.fail("não consegui consultar um Cliente");
        } finally {
            ConnectionFactory.closeConnection(conexao, null, null);
        }
        assertNotNull(aluno);

    }

    @Test
    public void selecionaTodosAlunos() {
        Connection conexao = null;
        List<Aluno> listaAluno = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getConnection();
            DAO<Aluno, Integer> AlunoDAO = PJPA.Aula02.Ex02.DAOFactory.getAlunoDAO(conexao);
            listaAluno = AlunoDAO.findAll();
                    
        } catch (Exception e) {
            System.err.println(e);
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
            }
            Assert.fail("não consegui consultar todos Alunos");
        } finally {
            ConnectionFactory.closeConnection(conexao, null, null);
        }
        assertNotNull(listaAluno);
    }

    @Test
    public void removeAluno() {
        Connection conexao = null;
        boolean alunoRemovido = false;
        try {
            conexao = ConnectionFactory.getConnection();
            DAO<Aluno, Integer> alunoDAO = PJPA.Aula02.Ex02.DAOFactory.getAlunoDAO(conexao);
            alunoRemovido = alunoDAO.remove(1234);
            
        } catch (Exception e) {
            System.err.println(e);
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
            }
            Assert.fail("não consegui excluir Aluno");
        } finally {
            ConnectionFactory.closeConnection(conexao, null, null);
        }
        assertTrue(alunoRemovido);
    }
    
    @Test
    public void atualizaAluno() {
        Connection conexao = null;
        Aluno aluno = null;
        try {
            conexao = ConnectionFactory.getConnection();
            DAO<Aluno, Integer> alunoDAO = PJPA.Aula02.Ex02.DAOFactory.getAlunoDAO(conexao);
            aluno = alunoDAO.getById(1233);
            alunoDAO.update(aluno);
        } catch (Exception e) {
            System.err.println(e);
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
            }
            Assert.fail("não consegui atualizar o Aluno");
        } finally {
            ConnectionFactory.closeConnection(conexao, null, null);
        }
        assertNotNull(aluno);
    }
}
