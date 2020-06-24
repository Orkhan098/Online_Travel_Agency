package project.User;

import project.Tour.Tour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String password;
    public String bookedTour;

    public static List<Tour> getTourList() {
        return tourList;
    }

    public static void setTourList(List<Tour> tourList) {
        User.tourList = tourList;
    }

    private static List<Tour> tourList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBookedTour() {
        return bookedTour;
    }

    public void setBookedTour(String bookedTour) {
        this.bookedTour = bookedTour;
    }
}
