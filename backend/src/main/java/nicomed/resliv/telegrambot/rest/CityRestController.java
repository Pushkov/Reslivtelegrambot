package nicomed.resliv.telegrambot.rest;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.CityDto;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityRestController {

    private final CityService cityService;

    @GetMapping
    public Collection<CityDto> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public CityDto findById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @GetMapping("/search")
    public CityDto findByName(@RequestParam String city) {
        return cityService.findByName(city);
    }

    @PostMapping
    public void create(@RequestBody CityCreateDto dto) {
        cityService.save(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CityCreateDto dto) {
        cityService.save(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }
}
