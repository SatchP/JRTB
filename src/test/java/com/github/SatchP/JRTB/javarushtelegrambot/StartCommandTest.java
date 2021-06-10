package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.StopCommand;

import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.START;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.StartComand.Start_message;

public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return Start_message;
    }

    @Override
    Command getCommand() {
        return new StopCommand( sendBotMessageService );
    }
}
