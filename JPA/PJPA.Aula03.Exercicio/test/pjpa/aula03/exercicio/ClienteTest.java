/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Cliente;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class ClienteTest {
    
   public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Testando novo cliente");

        EntityManager manager = JPAUtil.getManager();
        manager.getTransaction().begin();
        manager.persist(new Cliente(1, "Filipe", "1234"));
        manager.getTransaction().commit();
        manager.close();
        System.out.println("Consegui cadastrar novo cliente");
    }
    
}
