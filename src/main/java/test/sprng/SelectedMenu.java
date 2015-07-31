package test.sprng;

import javax.persistence.*;

/**
 * Created by Svetlana on 30-Jul-15.
 */
@Entity
@Table(name = "selectedMenu")
public class SelectedMenu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "price")
    private double price;

    //TODO multithreading
    @Column(name = "orderId")
    private int orderId;

    public SelectedMenu() {
    }

    public SelectedMenu(String name, double price, int orderId) {
        this.name = name;
        this.price = price;
        this.orderId = orderId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
