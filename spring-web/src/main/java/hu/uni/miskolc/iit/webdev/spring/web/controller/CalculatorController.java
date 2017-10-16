package hu.uni.miskolc.iit.webdev.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tothzs on 2017.10.16..
 */
@Controller
@RequestMapping(value = {"/calc","/calculator"})
public class CalculatorController {

    @RequestMapping(value = {"/add"})
    @ResponseBody
    public double add(@RequestParam( value = "a") double a, @RequestParam("b") double b){
        return a+b;
    }

    @RequestMapping(value = {"/sub"})
    @ResponseBody
    public double sub(@RequestParam( value = "a") double a, @RequestParam("b") double b){
        return a-b;
    }

    @RequestMapping(value = {"/mul"})
    @ResponseBody
    public double mul(@RequestParam( value = "a") double a, @RequestParam("b") double b){
        return a*b;
    }

    @RequestMapping(value = {"/div"})
    @ResponseBody
    public double div(@RequestParam( value = "a") double a, @RequestParam("b") double b){
        return a/b;
    }
}
