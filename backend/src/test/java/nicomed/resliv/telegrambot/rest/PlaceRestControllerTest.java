package nicomed.resliv.telegrambot.rest;

import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.PlaceService;
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
class PlaceRestControllerTest {

    @Mock
    private PlaceService placeService;

    @InjectMocks
    private PlaceRestController placeRestController;

    @Test
    void findAll() {
        Collection<PlaceDto> placeDtos = mock(Collection.class);
        when(placeService.findAll()).thenReturn(placeDtos);

        Collection<PlaceDto> result = placeRestController.findAll();

        assertFalse(result.isEmpty());

    }

    @Test
    void findById() {
        Long id = 1L;
        PlaceDto dto = mock(PlaceDto.class);
        when(placeService.findById(id)).thenReturn(dto);
        when(dto.getId()).thenReturn(1L);

        PlaceDto result = placeRestController.findById(id);

        assertFalse(Objects.isNull(result));
        assertEquals(1L, result.getId());
        verify(placeService, times(1)).findById(id);
    }
}