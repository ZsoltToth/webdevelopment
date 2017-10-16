package hu.uni.miskolc.iit.webdev.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tothzs on 2017.10.16..
 */
@Controller
public class GreetingsController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            return "Hello World!";
        }
        return "Hello "+name+"!";
    }
}
