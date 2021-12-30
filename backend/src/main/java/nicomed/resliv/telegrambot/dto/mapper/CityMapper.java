package nicomed.resliv.telegrambot.dto.mapper;

import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.qualifier.PlaceQualifier;
import nicomed.resliv.telegrambot.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = PlaceQualifier.class)
public interface CityMapper {


    @Mapping(target = "goodPlaces", source = "places", qualifiedByName = "getGood")
    @Mapping(target = "badPlaces", source = "places", qualifiedByName = "getBad")
    CityDto mapToDto(City city);

    City mapToEntity(CityCreateDto dto);

    void mapToEntity(@MappingTarget City city, CityCreateDto dto);
}
