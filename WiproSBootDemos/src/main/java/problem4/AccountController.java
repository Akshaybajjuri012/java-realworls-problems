package problem4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @GetMapping("/users/{id}/accounts")
    public List<AccountDemo> getAccounts(@PathVariable String id,
                                     @RequestParam String type,
                                     @RequestParam String status) {
        List<AccountDemo> accounts = new ArrayList<>();
        accounts.add(new AccountDemo(id, type, status));
        return accounts;
    }
}
