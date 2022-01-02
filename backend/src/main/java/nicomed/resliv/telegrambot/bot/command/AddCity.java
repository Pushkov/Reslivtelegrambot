package nicomed.resliv.telegrambot.bot.command;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import nicomed.telegram.botcommandmod.util.CommandUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@BotModCommand
public class AddCity extends BaseBotCommand {

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
        String args = CommandUtils.getCommandArguments(text);
        if (isEmpty(args)) {
            return getMessageText();
        }
        if (cityService.isCityExists(args)) {
            return "City with name: " + args + " already exists";
        }
        cityService.save(CityCreateDto.builder().name(args).build());
        return "City " + args + " added.";
    }
}
