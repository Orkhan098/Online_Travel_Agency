package project.Tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Tour.Tour;
import project.Tour.TourRepository;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours(){
        return (List<Tour>) tourRepository.findAll();
    }
    public void saveTour(Tour tour){
        tourRepository.save(tour);
    }
    public Tour get(Long id){
        return tourRepository.findById(id).get();
    }
    public void delete(Long id){
        tourRepository.deleteById(id);
    }


    //    public Tour getName(String description){
//        return tourRepository.findByName(description);
//    }
}
