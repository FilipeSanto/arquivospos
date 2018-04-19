/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Funcionario;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class FuncionarioTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Testando novo funcionario");

        EntityManager manager = JPAUtil.getManager();

        manager.getTransaction().begin();

        manager.persist(new Funcionario(1, "Joao", "4567"));

        manager.getTransaction().commit();
        manager.close();
        System.out.println("Consegui cadastrar novo funcionario");
    }
    
    
}
