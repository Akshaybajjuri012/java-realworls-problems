package problem5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/example/test")
    public String redirectToTest2() {
        
        return "redirect:/example/test2";
    }

    @GetMapping("/example/test2")
    public String showFinalPage() {
        
        return "test2"; 
    }
}

