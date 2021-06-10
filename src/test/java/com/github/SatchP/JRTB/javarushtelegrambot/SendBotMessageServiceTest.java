package com.github.SatchP.JRTB.javarushtelegrambot;

import com.github.SatchP.JRTB.javarushtelegrambot.bot.JavaRushTelegramBot;
import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageService;
import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import  org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceTest {

private SendBotMessageService sendBotMessageService;
private JavaRushTelegramBot   javaRushBot;


@BeforeEach
public void init(){
      javaRushBot = Mockito.mock( JavaRushTelegramBot.class );
      sendBotMessageService = new SendBotMessageServiceImpl( javaRushBot );
    }

    @Test
    public void shoulProperlySendMessage () throws TelegramApiException {
      //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage( chatId,message );

        //then
        Mockito.verify( javaRushBot ).execute( sendMessage );

    }

}
