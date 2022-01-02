package nicomed.resliv.telegrambot.repository;

import nicomed.resliv.telegrambot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByNameIgnoreCase(String name);


}
