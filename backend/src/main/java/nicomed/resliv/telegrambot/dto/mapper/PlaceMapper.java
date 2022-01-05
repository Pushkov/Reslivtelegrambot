package nicomed.resliv.telegrambot.dto.mapper;

import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PlaceMapper {

    PlaceDto mapToDto(Place Place);

    @Mapping(target = "id", ignore = true)
    Place mapToEntity(PlaceDto dto);

    @Mapping(target = "id", ignore = true)
    void mapToEntity(@MappingTarget Place place, PlaceDto dto);
}
