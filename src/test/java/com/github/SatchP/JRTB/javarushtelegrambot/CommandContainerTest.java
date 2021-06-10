package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.command.Command;
import com.github.SatchP.JRTB.javarushtelegrambot.command.CommandContainer;
import com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname;
import com.github.SatchP.JRTB.javarushtelegrambot.command.UnknownCommand;
import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

     private CommandContainer commandContainer;

     @BeforeEach
    public void init() {
         SendBotMessageService sendBotMessageService = Mockito.mock( SendBotMessageService.class );
         commandContainer = new CommandContainer( sendBotMessageService );
     }

     @Test
     public void shouldGetAllTheExistingCommands(){
         Arrays.stream( Commandname.values() ).forEach( commandname -> {
             Command command = commandContainer.retrieveCommand( commandname.getCommandName() );
             Assertions.assertNotEquals( UnknownCommand.class, command.getClass() );
         } );
     }

    @Test
    public void shouldReturnUnknownCommand() {
         //given
        String unknownCommand = "/fd";

        //when
        Command command = commandContainer.retrieveCommand( unknownCommand );

        //then
        Assertions.assertEquals( UnknownCommand.class, command.getClass() );
    }

}
