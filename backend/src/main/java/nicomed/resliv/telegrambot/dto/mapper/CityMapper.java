package nicomed.resliv.telegrambot.dto.mapper;

import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = PlaceMapper.class)
public interface CityMapper {

    CityDto mapToDto(City city);

    City mapToEntity(CityCreateDto dto);

    void mapToEntity(@MappingTarget City city, CityCreateDto dto);
}
