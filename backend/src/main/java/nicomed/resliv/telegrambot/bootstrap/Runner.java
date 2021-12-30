package nicomed.resliv.telegrambot.bootstrap;

import lombok.RequiredArgsConstructor;
import nicomed.resliv.telegrambot.dto.CityCreateDto;
import nicomed.resliv.telegrambot.dto.PlaceDto;
import nicomed.resliv.telegrambot.service.CityService;
import nicomed.resliv.telegrambot.service.PlaceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Runner implements CommandLineRunner {

    private final CityService cityService;
    private final PlaceService placeService;


    @Override
    public void run(String... args) throws Exception {


        cityService.save(CityCreateDto.builder()
                .name("City_1")
                .build());


        placeService.addPlace(1L, PlaceDto.builder().name("Good_1_1").isGood(true).build());
        placeService.addPlace(1L, PlaceDto.builder().name("Bad_1_1").build());
        placeService.addPlace(1L, PlaceDto.builder().name("Good_1_2").isGood(true).build());
        placeService.addPlace(1L, PlaceDto.builder().name("Bad_1_2").build());
//
        placeService.removePlace(1L, 2L);
//
//
//        cityService.save(CityCreateDto.builder()
//                .name("City_2")
//                .build());

//        cityService.delete(1L);

    }
}
