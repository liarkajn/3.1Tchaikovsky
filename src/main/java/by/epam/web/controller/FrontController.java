package main.java.by.epam.web.controller;

import main.java.by.epam.web.controller.command.Command;
import main.java.by.epam.web.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        command.execute(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);// второй раз встречаю такой код за день
        // откуда вы необходимость этого кода взяли?
        // ну вот просто подумайте. что такого полезного лелает ваш doPost?
    }
}
