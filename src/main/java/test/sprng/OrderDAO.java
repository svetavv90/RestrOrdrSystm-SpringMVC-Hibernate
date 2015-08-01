package test.sprng;

import java.util.List;
import java.util.Map;

/**
 * Created by Svitlana on 29-May-15.
 */
public interface OrderDAO {
    public List<Menu> selectMeal(Meal m, Cuisines c);
    public Meal choiceMeal(Integer n);
    public Cuisines choiceCuisines(Integer c);
    public List<SelectedMenu> menu(int id);
    public List<SelectedMenu> allSelected();
    public void deleteAllRecord();
    public void addToTrans();
    public void deleteRecords(int id);
    public boolean findDrink(int id);
}
