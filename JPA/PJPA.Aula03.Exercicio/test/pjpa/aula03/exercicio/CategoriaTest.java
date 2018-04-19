/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Categoria;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class CategoriaTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Testando nova categoria");

        EntityManager manager = JPAUtil.getManager();

        manager.getTransaction().begin();

        manager.persist(new Categoria(1, 10500, "teste"));

        manager.getTransaction().commit();
        manager.close();
        System.out.println("Consegui cadastrar nova categoria");
    }
}
