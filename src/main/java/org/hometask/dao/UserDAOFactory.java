package org.hometask.dao;

import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {
    private static UserDAOFactory userDaoFactory;

    private UserDAOFactory() {
    }

    public static UserDAOFactory getInstance(){
        if(userDaoFactory==null){
            return new UserDAOFactory();
        }
        return userDaoFactory;
    }

    public UserDAO getUserDaoFactory() {
        Properties config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (config.getProperty("DBConnection")) {
            case ("JDBC"):
                return new UserJdbcDAO();
            case ("Hibernate"):
                return new UserHibernateDAO();
        }
        return null;
    }
}
