package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.bot.flag.CommandFlagService;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import nicomed.telegram.botcommandmod.util.CommandUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@BotModCommand
public class RemoveCity extends BaseBotCommand {

    @Autowired
    private CommandFlagService flagService;
    @Autowired
    private CityService cityService;

    public RemoveCity() {
        super("remove_city", "");
    }

    @Override
    public String getMessageText() {
        return "city name for removing must not by empty. \n\r Add city name after command /remove_city";
    }

    @Override
    public String getMessageText(String text) {
        String args = CommandUtils.getCommandArguments(text);
        if (isEmpty(args)) {
            return getMessageText();
        }
        cityService.deleteByName(args);
        return "City " + args + " removed.";
    }

    public String removeCity(String text) {
        flagService.clearFlag();
        CityDto cityDto = cityService.findByName(text);
        if (Objects.isNull(cityDto)) {
            return "Город с названием:'" + text + "' не найден.";
        }
        cityService.delete(cityDto.getId());

        return "Город с названием:'" + text + "' удален.";
    }
}
