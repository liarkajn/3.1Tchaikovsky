package main.java.by.epam.web.dao;

import main.java.by.epam.web.dao.exception.DAOException;
import main.java.by.epam.web.domain.User;

public interface UserDAO {

    User findUser(String name, String surname) throws DAOException;

}
