package sia.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    /**
     * orderForm - method that populates the tacos order
     * @return the logical name of the view orderForm
     * */
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
}
