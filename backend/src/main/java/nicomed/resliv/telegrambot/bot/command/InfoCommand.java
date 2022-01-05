package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@BotModCommand
public class InfoCommand extends BaseBotCommand {

    @Autowired
    private CityService cityService;

    public InfoCommand() {
        super("info", "Список всех городов");
    }

    @Override
    public String getMessageText() {
        return "";
    }

    @Override
    public String getMessageText(String text) {

        return cityService.findAll().stream().map(CityDto::getName).collect(Collectors.joining(",\n\r", "Список известных городов:\n\r", "."));
    }
}
