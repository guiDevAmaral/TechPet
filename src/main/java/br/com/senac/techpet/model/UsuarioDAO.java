package br.com.senac.techpet.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UsuarioDAO {
    
    public Usuario validateUser(String login, String password) {
        
        EntityManager em = JPAUtil.getEntityManager();
        
        
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
        query.setParameter("login", login);
        try {
            Usuario user = query.getSingleResult();
            
            if (user.getSenha().equals(password)) {
                return user;
            }
        } catch (NoResultException e) {
            
        }
        return null; 
    }
}
    

