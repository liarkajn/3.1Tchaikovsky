package main.java.by.epam.web.controller.command.impl;

import main.java.by.epam.web.controller.command.Command;
import main.java.by.epam.web.domain.User;
import main.java.by.epam.web.service.ServiceFactory;
import main.java.by.epam.web.service.UserService;
import main.java.by.epam.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandImpl implements Command {// как в фильме про трех мушкетеров - Имя, сестра, имя...

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        String name = request.getParameter("name");// неименованные строки, и предупреждала же
        String surname = request.getParameter("surname");
        User user;
        try {
            user = userService.findUser(name, surname);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/page/userData.jsp").forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/page/error.jsp").forward(request, response);
        }
    }
}
