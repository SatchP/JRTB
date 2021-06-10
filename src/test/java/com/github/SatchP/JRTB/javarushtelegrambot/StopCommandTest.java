package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.StopCommand;

import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.STOP;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.StopCommand.STOP_MESSAGE;

public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand( sendBotMessageService );
    }
}
