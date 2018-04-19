/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Avaria;
import classes.Categoria;
import classes.Cliente;
import classes.Funcionario;
import classes.Locacao;
import classes.Multa;
import classes.Veiculo;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class LocacaoTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Testando nova Locacao");

        EntityManager manager = JPAUtil.getManager();

        manager.getTransaction().begin();

        Avaria avaria = new Avaria(1, 400, "Porta amassada", 1);
        Categoria categoria = new Categoria(2, 30000, "Veiculo de passeio");
        Cliente cliente = new Cliente(2, "Joao", "1234");
        Funcionario funcionario = new Funcionario(2, "Maria", "1234");
        Multa multa = new Multa();
        Veiculo veiculo = new Veiculo(2, categoria.getIdCategoria(), "Semi novo", "16/17", 3890);

        manager.persist(new Locacao(1, veiculo, cliente, funcionario, funcionario, 10, 2000));

        manager.getTransaction().commit();
        manager.close();
        System.out.println("Cadastro de nova locação ok");
    }

}
