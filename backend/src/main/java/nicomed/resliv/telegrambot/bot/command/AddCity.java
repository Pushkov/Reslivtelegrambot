package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.bot.flag.CommandFlagService;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;

import static nicomed.resliv.telegrambot.bot.flag.CommandFlag.ADD_CITY;

@BotModCommand
public class AddCity extends BaseBotCommand {

    @Autowired
    private CommandFlagService flagService;
    @Autowired
    private CityService cityService;

    public AddCity() {
        super("add_city", "command for adding city in database");
    }

    @Override
    public String getMessageText() {
        return "city name for adding must not by empty. \n\r Add city name after command /add_city";
    }

    @Override
    public String getMessageText(String text) {
        flagService.setFlag(ADD_CITY);
        return "Введите название города:";
    }

    public String saveCity(String text) {
        flagService.clearFlag();
        if (cityService.isCityExists(text)) {
            return "City with name: " + text + " already exists";
        }
        cityService.save(CityCreateDto.builder().name(text).build());
        return "Город " + text + " добавлен.";
    }
}
