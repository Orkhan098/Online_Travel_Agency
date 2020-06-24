package project.Tour;

import org.springframework.data.repository.CrudRepository;
import project.Tour.Tour;

public interface TourRepository extends CrudRepository<Tour,Long> {
    //    Tour findByName(String description);
}
