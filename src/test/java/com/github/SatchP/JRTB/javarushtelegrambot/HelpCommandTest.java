package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.HelpCommand;

import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.HELP;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.HelpCommand.HELP_MESSAGE;

public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand( sendBotMessageService );
    }
}
