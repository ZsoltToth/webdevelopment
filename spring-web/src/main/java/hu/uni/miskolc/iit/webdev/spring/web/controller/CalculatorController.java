package hu.uni.miskolc.iit.webdev.spring.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public double div(@RequestParam( value = "a") double a, @RequestParam("b") double b) throws ArithmeticException{
        if(b==0.0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    @ExceptionHandler(value={NumberFormatException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String handleNumberFormatException(){
        return "Calculator can process only numerical input!";
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public String divideByZero(){
        return "Cannot divide by zero!";
    }
}
