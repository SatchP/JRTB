package com.github.SatchP.JRTB.javarushtelegrambot.command;

/**
 * Enumeration for {@link Command}'s.
 */

public enum Commandname {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("");

    private final  String commandName;


    Commandname(String commandName) {
        this.commandName = commandName;
    }

public String getCommandName(){
        return commandName;
}
}
