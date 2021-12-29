package nicomed.resliv.telegrambot.repository;

import nicomed.resliv.telegrambot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
