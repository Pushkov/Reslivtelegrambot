package nicomed.resliv.telegrambot.bot.command;

import nicomed.resliv.telegrambot.bot.flag.CommandFlagService;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNoneEmpty;


@BotModCommand(isDefault = true)
public class DefaultCommand extends BaseBotCommand {

    @Autowired
    private CityService cityService;

    @Autowired
    private CommandFlagService flagService;

    public DefaultCommand() {
        super("", "Команда по умолчанию");
    }

    @Override
    public String getMessageText() {
        return "";
    }

    @Override
    public String getMessageText(String text) {
        if (flagService.isFlag()) {
            return flagService.process(text);
        }
        return findCity(text);
    }

    private String findCity(String text) {
        return getResultText(cityService.findByName(text));
    }

    private String getResultText(CityDto cityDto) {
        String result = "Про такой город информации нет.";
        if (!Objects.isNull(cityDto)) {
            result = "В городе " + cityDto.getName() + getPlacesResultText(cityDto);
        }
        return result;
    }

    private String getPlacesResultText(CityDto cityDto) {
        String result = " ничего примечательного нет.";
        String goodResult = getPlacesText(cityDto.getGoodPlaces());
        String badResult = getPlacesText(cityDto.getBadPlaces());
        if (isEmpty(goodResult) && isNoneEmpty(badResult)) {
            result = " мест достойных внимания нет, а вот " + badResult + " посещать не стоит.";
        } else if (isNoneEmpty(goodResult) && isEmpty(badResult)) {
            result = " стоит посетить " + goodResult + ", а мест, которые не стоит посещать, нет.";
        } else if (isNoneEmpty(goodResult) && isNoneEmpty(badResult)) {
            result = " стоит посетить " + goodResult + ", а вот " + badResult + " посещать не стоит.";
        }
        return result;
    }

    private String getPlacesText(List<PlaceDto> placeDtos) {
        String result = "";
        if (!CollectionUtils.isEmpty(placeDtos)) {
            result += placeDtos.stream().map(PlaceDto::getName).collect(Collectors.joining(", "));
        }
        return result;
    }
}
