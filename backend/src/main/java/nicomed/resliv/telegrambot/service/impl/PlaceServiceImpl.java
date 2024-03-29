package nicomed.resliv.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.dto.mapper.PlaceMapper;
import nicomed.resliv.telegrambot.model.Place;
import nicomed.resliv.telegrambot.repository.PlaceRepository;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.resliv.telegrambot.service.PlaceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PlaceServiceImpl extends AbstractService<PlaceDto, PlaceDto, Place, Long> implements PlaceService {

    private final PlaceRepository placeRepository;
    private final CityService cityService;
    private final PlaceMapper mapper;

    @Override
    public Place findEntityById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public PlaceDto findByName(String name) {
        return placeRepository.findByNameIgnoreCase(name).map(this::mapToDto).orElse(null);
    }

    @Override
    public void addPlace(Long id, PlaceDto dto) {
        Place place = mapToEntity(dto);
        place.setCity(cityService.findEntityById(id));
        getRepository().save(place);
    }

    @Transactional
    @Override
    public void removePlace(Long placeId) {
        getRepository().deleteById(placeId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(PlaceDto dto) {
        super.save(dto);
    }

    @Transactional
    @Override
    public void save(Long id, PlaceDto dto) {
        Place place = findEntityById(id);
        mapToEntity(place, dto);
    }

    @Override
    public PlaceDto mapToDto(Place entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Place mapToEntity(PlaceDto dto) {
        return mapper.mapToEntity(dto);
    }

    @Override
    public void mapToEntity(Place entity, PlaceDto dto) {
        mapper.mapToEntity(entity, dto);
    }

    @Override
    public JpaRepository<Place, Long> getRepository() {
        return placeRepository;
    }
}
