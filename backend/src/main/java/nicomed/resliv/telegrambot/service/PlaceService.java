package nicomed.resliv.telegrambot.service;

import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.model.Place;

public interface PlaceService extends CrudService<PlaceDto, PlaceDto, Long> {

    Place findEntityById(Long id);

    void save(Long id, PlaceDto dto);

    void addPlace(Long id, PlaceDto dto);

    void removePlace(Long placeId);
}
