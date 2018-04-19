/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Avaria;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class AvariaTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Testando nova avaria");

        EntityManager manager = JPAUtil.getManager();

        manager.getTransaction().begin();

        manager.persist(new Avaria(1, 150, "Farou quebrado", 1));

        manager.getTransaction().commit();
        manager.close();
        System.out.println("Consegui cadastrar nova avaria");
    }

}
