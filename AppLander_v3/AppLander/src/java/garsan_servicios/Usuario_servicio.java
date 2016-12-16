/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garsan_servicios;

import garsan_modelos.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author luciano
 */
public class Usuario_servicio {
    
    protected EntityManager em;

    public Usuario_servicio(EntityManager em) {
        this.em = em;
    }

    public List<Usuario> getAllUsuarios() {
        Query query = em.createQuery("SELECT e FROM Usuario e");
        return (List<Usuario>) query.getResultList();
    }

    public List<Usuario> getAllUsuariosCode() {
        Query query = em.createQuery("SELECT id_usuario FROM Usuario id_usuario");
        return (List<Usuario>) query.getResultList();
    }

    public void removeUsuario(int id_usuario) {
        Usuario emp = findUsuario(id_usuario);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (emp != null) {
                em.remove(emp);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        }

    }

    public void addUsuario(String name, String nacionality, String password) {
        Usuario u = new Usuario();

        EntityTransaction tx = em.getTransaction();

        u.setNameUsuario(name);
        u.setNacionality(nacionality);
        u.setPassword(password);

        try {
            tx.begin();
            em.persist(u);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Usuario findUsuario(int id_usuario) {
        return em.find(Usuario.class, id_usuario);
    }

    public boolean findUsuarioName(String name_usuario) {
        
        Usuario u = new Usuario();
        boolean encontrado = false;

        try {

            Query query = em.createQuery("select u from Usuario u where u.nameUsuario = :name_usuario").setParameter("name_usuario", name_usuario);
            u = (Usuario) query.getSingleResult();
            
            
            if(u.getNameUsuario().equalsIgnoreCase(name_usuario)){
                encontrado = true;
            }else{
                encontrado = false;
            }
            
        } catch (Exception e) {
            System.out.println("Error en el findUsuarioName");
        }
        
        return encontrado;
    }
    
    public boolean findUsuarioNamePass(String name_usuario, String pass) {
        Usuario u = new Usuario();
        boolean encontrado = false;

        try {

            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nameUsuario = :name_usuario").setParameter("name_usuario", name_usuario);
            u = (Usuario) query.getSingleResult();
            
            if(u.getPassword().equalsIgnoreCase(pass)){
                encontrado = true;
            }else{
                encontrado = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return encontrado;
    }
    
     public boolean findnick(String nick, String pass) {
         Usuario u = new Usuario();
        boolean ok = false;
        
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nameUsuario = :nick").setParameter("nick", nick);
            u = (Usuario) query.getSingleResult();
            if (u.getPassword().equalsIgnoreCase(pass)) {
                ok = true;
            } else {
                ok = false;
            }
        }catch(NoResultException e){
            ok = false;
        }
        return ok;
    }
    
}
