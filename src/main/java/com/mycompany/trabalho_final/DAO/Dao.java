/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Dao {
    
    //protected EntityManager em;        
    
    protected EntityManagerFactory emf; 
    protected EntityManager em;


    public Dao() {
         this.emf = javax.persistence.Persistence.createEntityManagerFactory("projetoVeiculosPU");
         this.em =  emf.createEntityManager();
    }
    
    
    public void salvar(Object object){
        if(object != null){
            em.getTransaction().begin();
            try{
                em.persist(object);
                em.getTransaction().commit();
            } catch(Exception e){
                e.printStackTrace();
                em.getTransaction().rollback();
            }
        }
    }
    
    public Object ler(Class classe, long id){
        Object object = null;
        try{
            object = em.find(classe, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return object;
    }
    
    public void alterar(Object object){
        em.getTransaction().begin();
        try{
            em.merge(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    public void deletar(Object object){
        em.getTransaction().begin();
        try{
            em.remove(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    

}
