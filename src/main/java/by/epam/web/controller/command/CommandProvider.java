package main.java.by.epam.web.controller.command;

import main.java.by.epam.web.controller.command.impl.CommandImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.AUTHORIZATION, new CommandImpl());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

}
