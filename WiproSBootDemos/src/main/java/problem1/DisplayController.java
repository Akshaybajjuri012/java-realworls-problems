package problem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayController {

    @Autowired
    private ClassKLM klm;

    @GetMapping("/display")
    public String displayMessage() {
        // This just confirms the call reached your autowired class
        klm.show(); // This prints to console
        return "Called klm.show(); Check console output!";
    }
}
