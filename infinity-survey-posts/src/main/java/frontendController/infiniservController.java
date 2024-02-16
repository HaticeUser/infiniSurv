package frontendController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class infiniservController {

    @GetMapping("/hello")
    public String infiniservDataController(){
        return "Hello data";
    }
}
