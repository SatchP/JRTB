package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.UnknownCommand;

import static com.github.SatchP.JRTB.javarushtelegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/asda";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand( sendBotMessageService );
    }
}
