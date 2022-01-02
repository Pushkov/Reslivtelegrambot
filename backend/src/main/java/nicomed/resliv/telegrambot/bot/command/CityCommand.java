package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@BotModCommand(isDefault = true)
public class CityCommand extends BaseBotCommand {

    @Autowired
    private CityService cityService;

    public CityCommand() {
        super("", "description");
    }

    @Override
    public String getMessageText() {
        return "";
    }

    @Override
    public String getMessageText(String text) {
        String result = "find nothing";
        CityDto city = cityService.findByName(text);
        if (!Objects.isNull(city)) {
            result = "Find city: " + city.getName();
        }


        return result;
    }
}
