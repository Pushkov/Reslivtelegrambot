package nicomed.resliv.telegrambot.rest;

import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityRestControllerTest {

    @Mock
    private CityService cityService;

    @InjectMocks
    private CityRestController cityRestController;

    @Test
    void findAll() {
        Collection<CityDto> cityDtos = mock(Collection.class);
        when(cityService.findAll()).thenReturn(cityDtos);

        Collection<CityDto> result = cityRestController.findAll();

        assertFalse(result.isEmpty());
        verify(cityService, times(1)).findAll();
    }

    @Test
    void findById() {
        Long id = 1L;
        CityDto dto = mock(CityDto.class);
        when(cityService.findById(id)).thenReturn(dto);
        when(dto.getId()).thenReturn(1L);

        CityDto result = cityRestController.findById(id);

        assertFalse(Objects.isNull(result));
        assertEquals(1L, result.getId());
        verify(cityService, times(1)).findById(id);
    }

    @Test
    void findByName() {
        String name = "name";
        CityDto dto = mock(CityDto.class);
        when(cityService.findByName(name)).thenReturn(dto);
        when(dto.getName()).thenReturn(name);

        CityDto result = cityService.findByName(name);

        assertFalse(Objects.isNull(result));
        assertEquals("name", result.getName());
        verify(cityService, times(1)).findByName(name);
    }
}