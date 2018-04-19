/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjpa.aula03.exercicio;

import classes.Veiculo;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Filipe
 */
public class VeiculoTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Teste de cadastro de veículo");

        EntityManager manager = JPAUtil.getManager();

        manager.getTransaction().begin();

        manager.persist(new Veiculo(1, 1, "Veiculo 4 portas", "VW Golf", 3105));

        manager.getTransaction().commit();
        manager.close();
        System.out.println("Teste 01 Ok!\n\n\n");
    }

}
