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

    //divide menu on cuisines and type of meal
    @RequestMapping("/")
    public String listMealP(Model model) {
        /*model.addAttribute("orderM", listMain(1, 1));//Polish main course
        model.addAttribute("orderMP", listMain(1, 2));//Polish dessert
        model.addAttribute("orderMPD", listMain(1, 3));//Polish drink
        model.addAttribute("orderMM", listMain(2, 1));//Mexican main course
        model.addAttribute("orderMML", listMain(2, 2));//Mexican dessert
        model.addAttribute("orderMMD", listMain(2, 3));//Mexican drink
        model.addAttribute("orderIM", listMain(3, 1));//Italian main course
        model.addAttribute("orderID", listMain(3, 2));//Italian dessert
        model.addAttribute("orderIDR", listMain(3, 3));//Italian drink*/
        model.addAttribute("order44", listMain(4, 4));//Additional
        for (int i = 1; i< 4; i++){
            for (int j = 1; j < 4; j++){
                model.addAttribute("order" + i + j, listMain(i, j));//Polish main course
            }
        }
        return "index";
    }
    public List<Menu> listMain(int csns, int ml) {
        Cuisines cuisines = orderDAO.choiceCuisines(csns);
        Meal meal = orderDAO.choiceMeal(ml);
        return orderDAO.selectMeal(meal, cuisines);
    }
    //my attempt to save result in list or array
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public  ModelAndView getReqwst(@RequestParam(value = "select") String[] select,
                                   @RequestParam(value = "name") String name,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        List<Menu> list = orderDAO.menu(name);
        for(int i=0; i< list.size(); i++){
            select = (String[]) list.toArray();
        }
        return new ModelAndView("result", "select", select);
    }
    //redirect to result page
    @RequestMapping("/result")
    public String selectCheck(Model model){
        return "result";
    }

}
