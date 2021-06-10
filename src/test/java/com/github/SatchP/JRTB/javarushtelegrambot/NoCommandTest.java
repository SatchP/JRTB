package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.NoCommand;

import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.NO;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.NoCommand.NO_MESSAGE;

public class NoCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand( sendBotMessageService );
    }
}
