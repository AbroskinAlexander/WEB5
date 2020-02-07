package Dao;


import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HiberUserDao implements DaoUsers {

    private SessionFactory sessionFactory;

    public HiberUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public boolean addUser(User user) {
        Session session = getSession();
        if (!userExist(user)) {
            Transaction trx = null;
            try {
                trx = session.beginTransaction();
                session.save(user);
                session.flush();
                trx.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                if (trx != null) {
                }
                trx.rollback();
            } finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> res = (List<User>) criteria.list();
        session.flush();
        session.getTransaction().commit();
        session.close();
        return res;
    }

    @Override
    public boolean userExist(User user) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        User res = (User) criteria.add(Restrictions.eq("name", user.getName())).uniqueResult();
        session.close();
        return res != null;
    }

    @Override
    public User getUserById(long id) {
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
        User user = getUserById(updateUser.getId());
        if (user!=null) {
            Transaction trx = null;
            try {
                trx = session.beginTransaction();
                if (updateUser.getName().length()!=0) {
                    user.setName(updateUser.getName());
                }
                if (updateUser.getSurname().length()!=0) {
                    user.setSurname(updateUser.getSurname());
                }
                if (updateUser.getPassword().length()!=0) {
                    user.setPassword(updateUser.getPassword());
                }
                if (updateUser.getBirthday().length()!=0) {
                    user.setBirthday(updateUser.getBirthday());
                }
                session.saveOrUpdate(user);
                session.flush();
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

    @Override
    public void deletUser(long id) {
        Session session = getSession();
        User user = getUserById(id);
        Transaction trx = null;
        try {
            trx = session.beginTransaction();
            session.delete(user);
            session.flush();
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

    }

}
