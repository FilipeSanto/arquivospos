/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Filipe
 */
public class JPAUtil {
    public static EntityManagerFactory mf;
    
    public static EntityManager getManager(){
        if(mf == null){
            mf = Persistence.createEntityManagerFactory("pjpabanco");
        }
        return mf.createEntityManager();
    }
    public static void closeManager(EntityManager manager){
        try{
            manager.close();
        }catch(Exception e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
