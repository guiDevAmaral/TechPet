package br.com.senac.techpet.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class HospedagemDAO {

    public void cadastrarHospedagem(Hospedagem h) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    
    public List<Hospedagem> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT h FROM Hospedagem h ");
            List<Hospedagem> hospedagens = consulta.getResultList();
            return hospedagens;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Hospedagem h = em.find(Hospedagem.class, id);
            if (h != null) {
                em.getTransaction().begin();
                em.remove(h);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    
    public void atualizar(Hospedagem c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    
    public Hospedagem obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Hospedagem.class, id);
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
}
