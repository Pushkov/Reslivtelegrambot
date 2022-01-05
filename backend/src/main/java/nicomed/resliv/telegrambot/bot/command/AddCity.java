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
        super("add_city", "Добавление нового города в базу данных");
    }

    @Override
    public String getMessageText() {
        return "";
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
