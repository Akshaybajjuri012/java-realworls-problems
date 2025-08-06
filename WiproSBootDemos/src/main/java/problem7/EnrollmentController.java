package problem7;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnrollmentController {

    @GetMapping("/enroll")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "enrollment-form";
    }

    @PostMapping("/enroll")
    public String processForm(@Valid @ModelAttribute("student") Student student,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "enrollment-form";
        }
        return "validation-success";
    }
}
