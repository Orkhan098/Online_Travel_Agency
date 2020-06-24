package project.Tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.User.User;
import project.User.UserService;

@Controller
public class TourController {


    private final TourService tourService;
    private final UserService userService;
    private Tour tour;
    private User user;

    @Autowired
    public TourController(TourService tourService, UserService userService) {
        this.tourService = tourService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model){
        model.addAttribute("listTours", tourService.getAllTours());
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newTour(Model model){
        Tour tour=new Tour();
        model.addAttribute("tour",tour);
        return "new";
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String postNewTour(@ModelAttribute("tour") Tour tour){
        tourService.saveTour(tour);
        return "redirect:/admin";
    }

    @RequestMapping("/edit/{id}")
    public String showEditedTour(@PathVariable Long id, Model model){
        model.addAttribute("tour",tourService.get(id));
        return "edit_tour";
    }
    @RequestMapping("/delete/{id}")
    public String deleteTour(@PathVariable Long id){
        tourService.delete(id);
        return "redirect:/admin";
    }

    //User Controller

    @RequestMapping("/user")
    public  String getUser(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "user";
    }


    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public String listPage(Model model){
        model.addAttribute("listTours", tourService.getAllTours());
        return "listOfTours";
    }

    @RequestMapping(value = "/saveUser", method=RequestMethod.POST)
    public String postUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/lists";
    }
    @RequestMapping("/select/{id}")
    public String selectedTour(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.get(id));
        tourService.delete(id);
        return "redirect:/admin";
    }

}
