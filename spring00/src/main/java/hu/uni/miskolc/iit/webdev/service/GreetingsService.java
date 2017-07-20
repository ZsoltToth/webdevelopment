package hu.uni.miskolc.iit.webdev.service;

/**
 * Created by tothzs on 2017.07.20..
 */
public interface GreetingsService {

    String welcome(String name);
    String farewell(String name);
}
