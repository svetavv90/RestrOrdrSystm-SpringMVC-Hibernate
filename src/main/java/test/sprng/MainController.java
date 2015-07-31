package test.sprng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Svitlana on 29-May-15.
 */
@Controller
@RequestMapping("/main")
public class MainController{
    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping("/")
    public ModelAndView listCuis() {
        return new ModelAndView("index");
    }

    @RequestMapping("/additional_page")
    public ModelAndView listMealAd() {
        return new ModelAndView("Additional", "order44", listMain(4, 4));
    }

    @RequestMapping("/Polish_cuisines")
    public String listPolMeal(Model model) {
        for (int i = 1; i< 4; i++){
                model.addAttribute("order1" + i, listMain(1, i));
        }
        model.addAttribute("order44", listMain(4, 4));
        return "Polish";
    }

    @RequestMapping("/Mexican_cuisines")
    public String listMexMeal(Model model) {
        for (int i = 1; i< 4; i++){
            model.addAttribute("order2" + i, listMain(2, i));
        }
        model.addAttribute("order44", listMain(4, 4));
        return "Mexican";
    }
    @RequestMapping("/Italian_cuisines")
    public String listItalMeal(Model model) {
        for (int i = 1; i< 4; i++){
            model.addAttribute("order3" + i, listMain(3, i));
        }
        model.addAttribute("order44", listMain(4, 4));
        return "Italian";
    }
    public List<Menu> listMain(int csns, int ml) {
        //supplementary method
        Cuisines cuisines = orderDAO.choiceCuisines(csns);
        Meal meal = orderDAO.choiceMeal(ml);
        return orderDAO.selectMeal(meal, cuisines);
    }
    @RequestMapping("/select")
    public ModelAndView deletePage(@RequestParam(required = false, value = "selected") int[] selected) {
        //show selected records
        if(selected!=null)
            for(int id: selected){
                orderDAO.menu(id);
            }
        return new ModelAndView("result", "res", orderDAO.allSelected());
    }
    @RequestMapping("/show_order_list")
    public ModelAndView showOrderList(){
        //redirect by "Order" button
        return new ModelAndView("result", "res", orderDAO.allSelected());
    }
    @RequestMapping("/commit")
    public ModelAndView commitTransaction(){
        //if commit button was clicked, add to AllTransaction table sum and delete record from table Selected Menu
        orderDAO.addToTrans();
        //delete this line, when multithreading will be ready
        orderDAO.deleteAllRecord();
        return new ModelAndView("index");
    }
}
