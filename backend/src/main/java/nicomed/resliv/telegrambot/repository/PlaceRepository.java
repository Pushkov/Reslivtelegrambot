package nicomed.resliv.telegrambot.repository;

import nicomed.resliv.telegrambot.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> findByNameIgnoreCase(String name);

}
