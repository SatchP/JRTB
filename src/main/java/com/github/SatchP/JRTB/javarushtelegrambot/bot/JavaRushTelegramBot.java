package com.github.SatchP.JRTB.javarushtelegrambot.bot;

import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.github.SatchP.JRTB.javarushtelegrambot.command.CommandContainer;
import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageServiceImpl;
import static com.github.SatchP.JRTB.javarushtelegrambot.command.Commandname.NO;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot{
    public static String COMMAND_PREFIX = "/";

    @Value( "${bot.username}" )
    private String name;

    @Value( "${bot.token}" )
    private String token;

    private final CommandContainer commandContainer;



    public JavaRushTelegramBot() {
        this.commandContainer = new CommandContainer( new SendBotMessageServiceImpl( this ));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }


}
