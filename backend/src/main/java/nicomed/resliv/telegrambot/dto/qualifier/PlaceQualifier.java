package nicomed.resliv.telegrambot.dto.qualifier;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.dto.mapper.PlaceMapper;
import nicomed.resliv.telegrambot.model.Place;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlaceQualifier {

    private final PlaceMapper placeMapper;

    @Named("getGood")
    public List<PlaceDto> getGood(List<Place> places) {
        return places.stream()
                .filter(Place::isGood)
                .map(placeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Named("getBad")
    public List<PlaceDto> getBad(List<Place> places) {
        return places.stream()
                .filter(p -> !p.isGood())
                .map(placeMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
