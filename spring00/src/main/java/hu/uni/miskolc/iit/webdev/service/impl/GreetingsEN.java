package hu.uni.miskolc.iit.webdev.service.impl;

import hu.uni.miskolc.iit.webdev.service.GreetingsService;

/**
 * Created by tothzs on 2017.07.20..
 */
public class GreetingsEN implements GreetingsService{
    public String welcome(String name) {
        return String.format("Hello %s!",name);
    }

    public String farewell(String name) {
        return String.format("Bye bye %s!",name);
    }
}
