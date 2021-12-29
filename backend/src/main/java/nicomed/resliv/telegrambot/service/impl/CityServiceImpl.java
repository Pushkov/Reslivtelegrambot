package nicomed.resliv.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.dto.mapper.CityMapper;
import nicomed.resliv.telegrambot.model.City;
import nicomed.resliv.telegrambot.repository.CityRepository;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityServiceImpl extends AbstractService<CityDto, City, Long> implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper mapper;

    @Override
    public JpaRepository<City, Long> getRepository() {
        return cityRepository;
    }

    @Override
    public CityDto mapToDto(City city) {
        return mapper.mapToDto(city);
    }

    @Override
    public City mapToEntity(CityDto dto) {
        return mapper.mapToEntity(dto);
    }

    @Override
    public void mapToEntity(City city, CityDto dto) {
        mapper.mapToEntity(city, dto);
    }
}
