package nicomed.resliv.telegrambot.bootstrap;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.CityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Runner implements CommandLineRunner {

    private final CityService cityService;


    @Override
    public void run(String... args) throws Exception {

        cityService.save(CityCreateDto.builder()
                .name("City_1")
                .build());

        cityService.addGoodPlace(1L, PlaceDto.builder().name("Good_1_1").build());
        cityService.addBadPlace(1L, PlaceDto.builder().name("Bad_1_1").build());
        cityService.addGoodPlace(1L, PlaceDto.builder().name("Good_1_2").build());
        cityService.addGoodPlace(1L, PlaceDto.builder().name("Bad_1_2").build());

        cityService.removeGoodPlace(1L, 3L);

    }
}
