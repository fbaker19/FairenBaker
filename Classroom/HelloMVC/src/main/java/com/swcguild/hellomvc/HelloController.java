package com.swcguild.hellomvc;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/hello"})// Routing at the controller method is optional
public class HelloController {//constructor
        
    public HelloController() {
    }
    
   @RequestMapping(value="/sayhi", method=RequestMethod.GET)// <-----method mapping is NOT optional
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller" );
        return "hello";
    }
}
