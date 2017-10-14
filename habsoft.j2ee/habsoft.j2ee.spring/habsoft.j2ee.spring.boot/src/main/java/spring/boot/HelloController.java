package spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/public/")
    public String publicMethod() {
        return "Greetings from public method!";
    }

    @RequestMapping("/private/")
    public String privateMethod() {
        return "Greetings from private method!";
    }
    
    @RequestMapping("/private/admin/")
    public String privateMethodOfAdmin() {
        return "Greetings from private method!";
    }

}