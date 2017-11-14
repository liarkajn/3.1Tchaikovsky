package main.java.by.epam.web.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
