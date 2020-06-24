package project.Tour;

import org.apache.tomcat.jni.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String beginDate;
    private String endDate;
    private float price;

    private static List<User> userList;

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        Tour.userList = userList;
    }


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
