package test.sprng;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by Svitlana on 29-May-15.
 */
public class OrderDaoImpl implements OrderDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Menu> selectAllMenu() {
        Query query = entityManager.createQuery("select m from Menu m", Menu.class);
        return (List<Menu>) query.getResultList();
    }

    @Override
    public List<Menu> selectMeal(Meal m, Cuisines c) {
       Query query = entityManager.createQuery("select m from Menu m where m.cuisines = :c and m.meal = :m", Menu.class);
        query.setParameter("m", m);
        query.setParameter("c", c);
        return (List<Menu>) query.getResultList();
    }

    @Override
    public Meal choiceMeal(Integer n) {
        return entityManager.find(Meal.class, n);
    }

    @Override
    public Cuisines choiceCuisines(Integer c) {
        return entityManager.find(Cuisines.class, c);
    }


    @Override
    public List<Menu> menu(String select) {
        Query query = entityManager.createQuery("select m from Menu m where m.name= :pattern", Menu.class);
        query.setParameter("pattern", select);
        return (List<Menu>) query.getResultList();
    }
}
