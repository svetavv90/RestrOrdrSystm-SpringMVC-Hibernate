package test.sprng;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Svitlana on 28-May-15.
 */
@Entity
@Table(name = "Cuisines")
public class Cuisines {
    @Id
    @Column(name = "CuisinesID")
    @GeneratedValue
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "cuisines")
    private List<Menu> order11;

    public Cuisines() {
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

    public List<Menu> getOrder11() {
        return order11;
    }

    public void setOrder11(List<Menu> menus) {
        this.order11 = menus;
    }

}
