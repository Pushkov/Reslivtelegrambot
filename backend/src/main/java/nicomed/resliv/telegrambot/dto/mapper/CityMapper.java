package nicomed.resliv.telegrambot.dto.mapper;

import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CityMapper {

    CityDto mapToDto(City city);

    @Mapping(target = "id", ignore = true)
    City mapToEntity(CityDto dto);

    @Mapping(target = "id", ignore = true)
    void mapToEntity(@MappingTarget City city, CityDto dto);
}
