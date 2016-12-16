/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garsan_servicios;

import garsan_modelos.Partida;
import garsan_modelos.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author luciano
 */
public class Partida_servicio {
    
    protected EntityManager em;

    public Partida_servicio(EntityManager em) {
        this.em = em;
    }

    public List<Partida> getAllPartidas() {
        Query query = em.createQuery("SELECT e FROM Partida e");
        return (List<Partida>) query.getResultList();
    }
    
    public List<Partida> getAllPartidasCode() {
        Query query = em.createQuery("SELECT id_partida FROM Partida id_partida");
        return (List<Partida>) query.getResultList();
    }

    public void removePartida(int id_partida) {
        Partida emp = findPartida(id_partida);
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if (emp != null) {
            em.remove(emp);
        }
            tx.commit();
        }catch(Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
        }
        
    }

    public void addPartida(Date dateBegin, Date dateFinish, int score, String id_usuario_fk) {
        Partida p = new Partida();
       
        EntityTransaction tx = em.getTransaction();
        
        p.setDateBegin(dateBegin);
        p.setDateFinish(dateFinish);
        p.setScore(score);
        p.setIdUsuarioFk(id_usuario_fk);
        
        
        try {
            tx.begin();
            em.persist(p);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void addFullPartida(Integer score,Date d) {
        Query query2 = em.createQuery("SELECT max(p.idPartida) FROM Partida p");
        Integer i=(Integer) query2.getSingleResult();
        System.out.println(i);
        
        Query query = em.createQuery("SELECT p FROM Partida p WHERE p.idPartida = :idPartida").setParameter("idPartida", i);
        Partida p = new Partida();
        p = (Partida)query.getSingleResult();
        p.setScore(score);
        p.setDateFinish(d);
        modificarPartida(p);
          
 
    }

    
    public Partida findPartida(int id_partida) {
        return em.find(Partida.class, id_partida);
    }


public void modificarPartida(Partida part) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.flush();
            em.refresh(part);
            em.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}