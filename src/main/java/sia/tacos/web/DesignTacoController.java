package sia.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sia.tacos.Ingredient;
import sia.tacos.Ingredient.Type;
import sia.tacos.Taco;
import sia.tacos.TacoOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    /**
     * addIngredientsToModel - method that adds the selected taco
     * ingredients to the model
     * @param model
     * */
    @ModelAttribute
    public void addIngredientsToModel(Model model){

        /**
         * Get all possible taco ingredients
         * */
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );


        /**
         * Get all the taco ingredient types and add model attribute for each
         * given type
         * */
        Type[] types = Ingredient.Type.values();
        for (Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    /**
     * order - creates a new TacoOrder object that holds state for the order
     * being built as the user creates tacos across multiple requests
     * @return a new TacoOrder object
     * */
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    /**
     * taco - creates a new Taco object that will be placed into the
     * model so that the view rendered will have a non-null object to display
     * @return a new Taco object
     * */
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    /**
     * showDesignForm - method that handles the GET request from "/design"
     * It populates the given model with an empty Taco object under a key
     * whose name is "design"
     * @return the logical name of the view that will be used to render model
     * to the browser
     * */
    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    /**
     * filterByType - method that filters a list of ingredients by the given type
     * @param ingredients - the taco ingredients to be filtered
     * @param  type - the taco type used to filter the ingredients
     * @return filtered ingredients
     * */
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
