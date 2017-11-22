package main.java.by.epam.web.service.impl;

import main.java.by.epam.web.dao.DAOFactory;
import main.java.by.epam.web.dao.UserDAO;
import main.java.by.epam.web.dao.exception.DAOException;
import main.java.by.epam.web.domain.User;
import main.java.by.epam.web.service.UserService;
import main.java.by.epam.web.service.exception.ServiceException;
import main.java.by.epam.web.service.validation.UserValidator;
import main.java.by.epam.web.service.validation.UserInputDataValidator;

public class UserServiceImpl implements UserService {

    @Override
    public User findUser(String name, String surname) throws ServiceException {

        if (!UserInputDataValidator.validate(name, surname)) {
            throw new ServiceException("Name or Surname field is empty");
        }
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        User user;
        try {
            user = userDAO.findUser(name, surname);
            UserValidator userValidator = new UserValidator();
            userValidator.validateUser(user);
        } catch (DAOException e) {
            throw new ServiceException(e);// крайне желательно свое исключение выбрасывать и со своим сообщением
        }
        return user;
    }

}
