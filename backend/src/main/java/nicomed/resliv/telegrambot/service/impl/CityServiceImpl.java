package nicomed.resliv.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.dto.mapper.CityMapper;
import nicomed.resliv.telegrambot.dto.mapper.PlaceMapper;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.model.Place;
import nicomed.resliv.telegrambot.repository.CityRepository;
import nicomed.resliv.telegrambot.repository.PlaceRepository;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CityServiceImpl extends AbstractService<CityCreateDto, CityDto, City, Long> implements CityService {

    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;
    private final CityMapper mapper;
    private final PlaceMapper placeMapper;


    @Override
    public City findEntityById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void save(Long id, CityCreateDto dto) {
        City city = getRepository().findById(id).orElse(null);
        if (!Objects.isNull(city)) {
            mapToEntity(city, dto);
        }
    }

    @Transactional
    @Override
    public void addGoodPlace(Long id, PlaceDto dto) {
        findEntityById(id).getGoodPlaces().add(placeMapper.mapToEntity(dto));
    }

    @Transactional
    @Override
    public void removeGoodPlace(Long cityId, Long placeId) {
        List<Place> goodPlaces = findEntityById(cityId).getGoodPlaces();
        if (!CollectionUtils.isEmpty(goodPlaces)) {
            Place place = goodPlaces.stream().filter(p -> p.getId() == placeId).findFirst().orElse(null);
            if (!Objects.isNull(place)) {
                goodPlaces.remove(place);
            }
        }
    }

    @Transactional
    @Override
    public void addBadPlace(Long id, PlaceDto dto) {
        findEntityById(id).getBadPlaces().add(placeMapper.mapToEntity(dto));
    }

    @Transactional
    @Override
    public void removeBadPlace(Long cityId, Long placeId) {

    }

//    protected Place findPlaceByN

    @Override
    public JpaRepository<City, Long> getRepository() {
        return cityRepository;
    }

    @Override
    public CityDto mapToDto(City city) {
        return mapper.mapToDto(city);
    }

    @Override
    public City mapToEntity(CityCreateDto dto) {
        return mapper.mapToEntity(dto);
    }

    @Override
    public void mapToEntity(City city, CityCreateDto dto) {
        mapper.mapToEntity(city, dto);
    }
}
