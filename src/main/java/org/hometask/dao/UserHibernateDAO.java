package org.hometask.dao;


import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hometask.model.User;
import org.hometask.util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public boolean addUser(User user) {
        if (userExist(user)) {
            return false;
        } else {
            Session session = getSession();
            Transaction trx = null;
            try {
                trx = session.beginTransaction();
                session.save(user);
                trx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (trx != null) {
                }
                trx.rollback();
            } finally {
                session.close();
            }
        }
        return true;
    }

    @Override
    public List<User> getAllUser() {
        Session session = getSession();
        return session.createQuery("FROM User").list();
    }

    @Override
    public boolean userExist(User user) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        User res = (User) criteria.add(Restrictions.eq("email", user.getEmail())).uniqueResult();
        session.close();
        return res != null;
    }

    @Override
    public User getUserById(Long id) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        User res = null;
        res = (User) criteria.add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return res;
    }

    @Override
    public void updateUser(User updateUser) {
        Session session = getSession();
        Transaction trx = null;
        try {
            trx = session.beginTransaction();
            session.saveOrUpdate(updateUser);
            trx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deletUser(Long id) {
        Session session = getSession();
        User user = getUserById(id);
        Transaction trx = null;
        try {
            trx = session.beginTransaction();
            session.delete(user);
            trx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }


    }

    @Override
    public void deletAllUsers() {
        Transaction trx = null;
        Session session = getSession();
        try {
            trx = session.getTransaction();
            session.createSQLQuery("DELETE FROM User");
            trx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
