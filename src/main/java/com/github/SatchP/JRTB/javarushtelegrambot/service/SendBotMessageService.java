package com.github.SatchP.JRTB.javarushtelegrambot.service;


/**
 * Service for sending messages via telegram-bot.
 */
public interface SendBotMessageService {

void sendMessage(String chatId, String message);

}
