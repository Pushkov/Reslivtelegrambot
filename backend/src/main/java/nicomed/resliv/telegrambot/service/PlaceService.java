package nicomed.resliv.telegrambot.service;

import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.model.Place;

public interface PlaceService extends CrudService<PlaceDto, PlaceDto, Long> {

    Place findEntityById(Long id);
}
