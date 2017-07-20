package hu.uni.miskolc.iit.webdev.service.impl;

import hu.uni.miskolc.iit.webdev.service.GreetingsService;

/**
 * Created by tothzs on 2017.07.20..
 */
public class GreetingsHU implements GreetingsService {
    public String welcome(String name) {
        return String.format("Szia %s!",name);
    }

    public String farewell(String name) {
        return String.format("Viszlat %s",name);
    }
}
