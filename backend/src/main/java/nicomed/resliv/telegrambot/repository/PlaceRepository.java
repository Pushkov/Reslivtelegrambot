package nicomed.resliv.telegrambot.repository;

import nicomed.resliv.telegrambot.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
