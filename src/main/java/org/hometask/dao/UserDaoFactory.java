package org.hometask.dao;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDaoFactory userDaoFactory;

    private UserDaoFactory() {
    }

    public static UserDaoFactory getInstance(){
        if(userDaoFactory==null){
            return new UserDaoFactory();
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
