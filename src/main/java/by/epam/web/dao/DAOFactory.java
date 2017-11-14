package main.java.by.epam.web.dao;

import main.java.by.epam.web.dao.impl.SQLUserDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private UserDAO userDAO = new SQLUserDAO();

    private DAOFactory() { }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

}
