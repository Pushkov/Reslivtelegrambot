package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.bot.flag.CommandFlagService;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.model.Place;
import nicomed.resliv.telegrambot.repository.PlaceRepository;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;

import static nicomed.resliv.telegrambot.bot.flag.CommandFlag.*;

@BotModCommand
public class AddPlace extends BaseBotCommand {

    @Autowired
    private CommandFlagService flagService;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private CityService cityService;

    private Long cityId;
    private boolean isGood = true;

    public AddPlace() {
        super("add_place", "add place");
    }

    @Override
    public String getMessageText() {
        return "1";
    }

    @Override
    public String getMessageText(String text) {
        flagService.setFlag(ADD_PLACE_CITY);
        return "Введите название города, для добавления места:";
    }

    public String getIsGoodText(String cityName) {
        CityDto city = cityService.findByName(cityName);
        if (city != null) {
            this.cityId = city.getId();
            flagService.setFlag(ADD_PLACE_GRADE);
            return "Введите рекомендуете ли вы место для посещения? (1/0, Да/Нет)";
        }
        flagService.clearFlag();
        return "Город с названием \"" + cityName + "\" -  не найден.";
    }

    public String getPlaceNameText(String text) {

        if (hasGood(text)) {
            this.isGood = true;
        } else {
            this.isGood = false;
        }
        flagService.setFlag(ADD_PLACE_NAME);
        return "Введите название места:";
    }

    public String savePlace(String placeName) {
        City city = cityService.findEntityById(this.cityId);
        placeRepository.save(
                Place.builder()
                        .name(placeName)
                        .isGood(this.isGood)
                        .city(city)
                        .build()
        );
        flagService.clearFlag();
        return "Место " + placeName + " в городе " + city.getName() + " добавлено.";
    }

    private boolean hasGood(String isGood) {
        String good = isGood.trim().toLowerCase();
        return good.startsWith("д")
                || good.startsWith("y")
                || good.startsWith("1")
                || good.startsWith("g");
    }
}
