package nicomed.resliv.telegrambot.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "CITY_GOOD_PLACES",
            joinColumns = @JoinColumn(name = "CITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLACE_ID"))
    private List<Place> goodPlaces = new ArrayList<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "CITY_BAD_PLACES",
            joinColumns = @JoinColumn(name = "CITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLACE_ID"))
    private List<Place> badPlaces = new ArrayList<>();


}
