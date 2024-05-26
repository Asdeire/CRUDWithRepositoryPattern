package com.asdeire.persistence.repository;

import com.asdeire.persistence.model.UserRole;
import com.asdeire.persistence.repository.impl.UserRoleRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static com.asdeire.persistence.utils.HibernateUtil.getSessionFactory;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    @Override
    public void save(UserRole userRole) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(userRole);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public UserRole findById(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            return session.get(UserRole.class, id);
        }
    }

    @Override
    public List<UserRole> findAll() {
        try (Session session = getSessionFactory().openSession()) {
            Query<UserRole> query = session.createQuery("FROM UserRole", UserRole.class);
            return query.list();
        }
    }

    @Override
    public void update(UserRole userRole) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(userRole);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(UserRole userRole) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(userRole);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
