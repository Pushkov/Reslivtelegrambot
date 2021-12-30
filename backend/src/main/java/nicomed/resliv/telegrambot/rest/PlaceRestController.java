package nicomed.resliv.telegrambot.rest;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RequestMapping("/places")
@RestController
public class PlaceRestController {

    private final PlaceService placeService;

    @GetMapping
    public Collection<PlaceDto> findAll() {
        return placeService.findAll();
    }

    @GetMapping("/{id}")
    public PlaceDto findById(@PathVariable Long id) {
        return placeService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody PlaceDto dto) {
        placeService.save(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PlaceDto dto) {
        placeService.save(id, dto);
    }

}
