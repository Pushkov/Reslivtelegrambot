package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.bot.flag.CommandFlagService;
import nicomed.resliv.telegrambot.config.BotDataManager;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.PlaceService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import static nicomed.resliv.telegrambot.bot.flag.CommandFlag.REMOVE_PLACE;

@BotDataManager
@BotModCommand
public class RemovePlace extends BaseBotCommand {

    @Autowired
    private CommandFlagService flagService;
    @Autowired
    private PlaceService placeService;

    public RemovePlace() {
        super("remove_place", "Удаление памятного места из базы данных.");
    }

    @Override
    public String getMessageText() {
        return "";
    }

    @Override
    public String getMessageText(String text) {
        flagService.setFlag(REMOVE_PLACE);
        return "Введите название удаляемого места:";
    }

    public String removePlace(String text) {
        flagService.clearFlag();
        PlaceDto placeDto = placeService.findByName(text);
        if (Objects.isNull(placeDto)) {
            return "Место с названием:'" + text + "' не найдено.";
        }
        placeService.removePlace(placeDto.getId());

        return "Место с названием:'" + text + "' удалено.";
    }
}
