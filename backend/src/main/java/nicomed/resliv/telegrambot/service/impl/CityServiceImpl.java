package nicomed.resliv.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.mapper.CityMapper;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.repository.CityRepository;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CityServiceImpl extends AbstractService<CityCreateDto, CityDto, City, Long> implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper mapper;

    @Override
    public Boolean isCityExists(String cityName) {
        City city = City.builder().name(cityName).build();
        ExampleMatcher caseInsensitiveExMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<City> example = Example.of(city, caseInsensitiveExMatcher);
        return cityRepository.exists(example);
    }

    @Override
    public City findEntityById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public CityDto findByName(String name) {
        City city = cityRepository.findByNameIgnoreCase(name).orElse(null);
        if (Objects.isNull(city)) {
            return null;
        }
        return mapToDto(city);
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
