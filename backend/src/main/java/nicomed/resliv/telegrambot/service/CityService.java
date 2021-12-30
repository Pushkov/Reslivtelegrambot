package nicomed.resliv.telegrambot.service;

import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.model.City;

public interface CityService extends CrudService<CityCreateDto, CityDto, Long> {

    City findEntityById(Long id);

    void save(Long id, CityCreateDto dto);

}
