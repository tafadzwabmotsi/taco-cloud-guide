package sia.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import sia.tacos.TacoOrder;

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

    /**
     * processOder - method that handles the submitted order
     * @param order - the tacos order submitted
     * @param sessionStatus - manages the status of the session
     * @return string representing the logical view name
     * */
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        
        if (errors.hasErrors()){
            return "orderForm";
        }
        
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
