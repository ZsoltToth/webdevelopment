package hu.uni.miskolc.iit.webdev;

import hu.uni.miskolc.iit.webdev.config.ExampleConfiguration;
import hu.uni.miskolc.iit.webdev.service.GreetingsService;
import hu.uni.miskolc.iit.webdev.service.impl.GreetingsHU;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GreetingsService greetings;
        /*
        Do not hard code the dependency.
         */
//        greetings= new GreetingsHU();

        ApplicationContext context;
        /*
        XML based configuration
        It works fine.
        Spring Web MVC prefers Annotation based configuration.
         */
//        context = new ClassPathXmlApplicationContext("application-context.xml");

        /*
        Annotation based configuration.
        This is the preferred choice currently.
         */
        context = new AnnotationConfigApplicationContext(ExampleConfiguration.class);

        greetings = (GreetingsService) context.getBean("greetingsService");

        String username = "Web Developer";
        System.out.println(greetings.welcome(username));
        System.out.println(greetings.farewell(username));
    }
}
