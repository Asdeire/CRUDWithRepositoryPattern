package com.asdeire.persistence.repository;

import com.asdeire.persistence.model.Permission;
import com.asdeire.persistence.repository.impl.PermissionRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static com.asdeire.persistence.utils.HibernateUtil.getSessionFactory;

public class PermissionRepositoryImpl implements PermissionRepository {

    @Override
    public void save(Permission permission) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(permission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Permission findById(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            return session.get(Permission.class, id);
        }
    }

    @Override
    public List<Permission> findAll() {
        try (Session session = getSessionFactory().openSession()) {
            Query<Permission> query = session.createQuery("FROM Permission", Permission.class);
            return query.list();
        }
    }

    @Override
    public void update(Permission permission) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(permission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Permission permission) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(permission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
