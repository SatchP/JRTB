package com.github.SatchP.JRTB.javarushtelegrambot.command;
import com.github.SatchP.JRTB.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartComand implements Command {

  private final SendBotMessageService sendBotMessageService;

  public final static String Start_message = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.

    public StartComand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage( update.getMessage().getChatId().toString(),Start_message );

    }
}
