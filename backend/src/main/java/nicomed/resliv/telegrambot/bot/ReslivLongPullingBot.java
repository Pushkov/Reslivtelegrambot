package nicomed.resliv.telegrambot.bot;

import lombok.RequiredArgsConstructor;
import nicomed.telegram.botcommandmod.BotCommandMod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@RequiredArgsConstructor
@Component
public class ReslivLongPullingBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String BOT_TOKEN;
    @Value("${bot.name}")
    private String BOT_USER_NAME;

    private final BotCommandMod botCommandMod;

    @Override
    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendMessage(botCommandMod.getSendMessage(update));
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
