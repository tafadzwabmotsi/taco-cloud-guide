package sia.tacos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    /**
     * List of customer's tacos
     * */
    private List<Taco> tacos = new ArrayList<>();

    /**
     * addTaco - method that adds each taco to
     * the customer's order
     * @param taco - a taco object
     * */
    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
