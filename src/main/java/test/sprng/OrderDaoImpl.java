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
    public List<Menu> selectMeal(Meal m, Cuisines c) {//use
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
    public List<SelectedMenu> menu(int id) {
        Query query = entityManager.createQuery("select m from Menu m where m.id=:id", Menu.class);
        query.setParameter("id", id);
        Menu menu = (Menu) query.getSingleResult();
        List<SelectedMenu> list = new LinkedList<>();
        //last parameter = 1. I created this parameter to multithreading access to DB
        //if new worker connect to DB and create new order, this index must incrementing
        SelectedMenu selectedMenu = new SelectedMenu(menu.getName(), menu.getPrice(), 1);
        entityManager.getTransaction().begin();
        entityManager.persist(selectedMenu);
        entityManager.getTransaction().commit();
        list.add(selectedMenu);
        return list;
    }

    @Override
    public List<SelectedMenu> allSelected(){
        Query query = entityManager.createQuery("SELECT a FROM SelectedMenu a ");/*where a.orderId=1*/
        return (List<SelectedMenu>) query.getResultList();
    }

    @Override
    public void deleteAllRecord(){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from SelectedMenu s");/*update SelectedMenu s set s.orderId=0*/
            query.executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void addToTrans(){
        try{
            Query query = entityManager.createQuery("SELECT sum (a.price) FROM SelectedMenu a");
            double sum = (double) query.getSingleResult();
            entityManager.getTransaction().begin();
            AllTransaction aTr = new AllTransaction(sum);
            entityManager.persist(aTr);
            entityManager.getTransaction().commit();
        }catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
