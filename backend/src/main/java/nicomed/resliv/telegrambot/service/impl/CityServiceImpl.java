package nicomed.resliv.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.mapper.CityMapper;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.repository.CityRepository;
import nicomed.resliv.telegrambot.repository.PlaceRepository;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CityServiceImpl extends AbstractService<CityCreateDto, CityDto, City, Long> implements CityService {

    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;
    private final CityMapper mapper;


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
