package test.sprng;

import javax.persistence.*;

/**
 * Created by Svetlana on 30-Jul-15.
 */
@Entity
@Table(name = "allTransaction")
public class AllTransaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "summary")
    private double summary;

    public AllTransaction() {
    }

    public AllTransaction(double summary) {
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }
}
