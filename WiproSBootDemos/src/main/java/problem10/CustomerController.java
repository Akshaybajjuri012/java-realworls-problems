package problem10;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @GetMapping("/customer/form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @PostMapping("/customer/save")
    public String submitForm(@Valid @ModelAttribute("customer") Customer customer,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "customerform";
        }
        return "customerSuccess";
    }
}
