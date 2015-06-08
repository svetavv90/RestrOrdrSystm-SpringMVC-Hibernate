package test.sprng;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Svitlana on 28-May-15.
 */
@Entity
@Table(name = "Menu")
public class Menu{

    @Id
    @Column(name = "MenuID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Column(name = "CuisinesID")
    @ManyToOne
    @JoinColumn(name = "CuisinesID")
    private Cuisines cuisines;

    //@Column(name = "MealID")
    @ManyToOne
    @JoinColumn(name = "MealID")
    private Meal meal;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Double price;
    public Menu(){}
    public Menu(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Meal getMealID() {
        return meal;
    }

    public void setMealID(Meal mealID) {
        this.meal = mealID;
    }

    public Cuisines getCuisines() {
        return cuisines;
    }

    public void setCuisines(Cuisines cuisinesID) {
        this.cuisines = cuisinesID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
