package com.github.SatchP.JRTB.javarushtelegrambot.command;

import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageService;

import  com.google.common.collect.ImmutableMap;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */

public class CommandContainer {
    private final ImmutableMap.Builder<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String,Command>builder()
                .put(START.getCommandName(), new StartComand( sendBotMessageService ) )
                .put(STOP.getCommandName(), new StopCommand( sendBotMessageService ) )
                .put(HELP.getCommandName(), new HelpCommand( sendBotMessageService ) )
                .put(NO.getCommandName(), new NoCommand( sendBotMessageService ) );

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.build().getOrDefault(commandIdentifier,unknownCommand);
    }
}
