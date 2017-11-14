package main.java.by.epam.web.service;

import main.java.by.epam.web.domain.User;
import main.java.by.epam.web.service.exception.ServiceException;

public interface UserService {

    User findUser(String name, String surname) throws ServiceException;

}
