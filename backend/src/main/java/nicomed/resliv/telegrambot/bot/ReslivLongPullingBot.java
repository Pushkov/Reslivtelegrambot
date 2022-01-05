package nicomed.resliv.telegrambot.bot;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.config.BotConfig;
import nicomed.telegram.botcommandmod.BotCommandMod;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@RequiredArgsConstructor
@Component
public class ReslivLongPullingBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    private final BotCommandMod botCommandMod;

    @Override
    public String getBotUsername() {
        return botConfig.getUSERNAME();
    }

    @Override
    public String getBotToken() {
        return botConfig.getTOKEN();
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
