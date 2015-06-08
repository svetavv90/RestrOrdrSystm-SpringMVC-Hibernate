package test.sprng;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Svitlana on 28-May-15.
 */
@Entity
@Table(name = "Meal")
public class Meal {
    @Id
    @Column(name = "MealID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "meal")
    private List<Menu> menus;

    public Meal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
