package com.asdeire.persistence.repository;

import com.asdeire.persistence.repository.impl.RoleRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.management.relation.Role;

import java.util.List;

import static com.asdeire.persistence.utils.HibernateUtil.getSessionFactory;

public class RoleRepositoryImpl implements RoleRepository {

    @Override
    public void save(Role role) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        }
    }

    @Override
    public List<Role> findAll() {
        try (Session session = getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery("FROM Role", Role.class);
            return query.list();
        }
    }

    @Override
    public void update(Role role) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Role role) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
