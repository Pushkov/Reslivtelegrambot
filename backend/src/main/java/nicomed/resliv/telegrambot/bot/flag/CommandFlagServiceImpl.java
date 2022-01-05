package nicomed.resliv.telegrambot.bot.flag;

import nicomed.resliv.telegrambot.bot.command.AddCity;
import nicomed.resliv.telegrambot.bot.command.AddPlace;
import nicomed.resliv.telegrambot.bot.command.RemoveCity;
import nicomed.resliv.telegrambot.bot.command.RemovePlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static nicomed.resliv.telegrambot.bot.flag.CommandFlag.*;

@Service
public class CommandFlagServiceImpl implements CommandFlagService {

    @Lazy
    @Autowired
    private AddPlace addPlace;
    @Lazy
    @Autowired
    private AddCity addCity;
    @Lazy
    @Autowired
    private RemoveCity removeCity;
    @Lazy
    @Autowired
    private RemovePlace removePlace;

    private CommandFlag flag = CommandFlag.NONE;

    @Override
    public boolean isFlag() {
        return flag != CommandFlag.NONE;
    }

    @Override
    public CommandFlag getFlag() {
        return flag;
    }

    @Override
    public void setFlag(CommandFlag flag) {
        this.flag = flag;
    }

    @Override
    public void clearFlag() {
        flag = CommandFlag.NONE;
    }

    @Override
    public String process(String text) {
        String message = text;
        if (flag == ADD_PLACE_CITY) {
            message = addPlace.getIsGoodText(text);
        } else if (flag == ADD_PLACE_GRADE) {
            message = addPlace.getPlaceNameText(text);
        } else if (flag == ADD_PLACE_NAME) {
            message = addPlace.savePlace(text);
        } else if (flag == ADD_CITY) {
            message = addCity.saveCity(text);
        } else if (flag == REMOVE_PLACE) {
            message = removePlace.removePlace(text);
        } else if (flag == REMOVE_CITY) {
            message = removeCity.removeCity(text);
        }
        return message;
    }
}
