package main.java.by.epam.web.service;

import main.java.by.epam.web.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private UserService userService = new UserServiceImpl();

    private ServiceFactory() { }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

}
