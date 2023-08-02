package com.practice.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// import com.practice.learnspringframework.game.PacmanGame;

// configuration file containing spring beans.
@Configuration
@ComponentScan("com.practice.learnspringframework.game") // to tell Spring where to find components to add as beans
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
        /*
         * // create spring context using the
         * //spring configuration Gamingconfiguration class
         * AnnotationConfig = tells that the spring is congifured in annotation
         * ApplicationContext = finds the beans; initializes and holds the beans.
         * App03GamingSpringBeanas.class tells where to start the search
         */
        // using try block to prevent RESOURCE LEAK
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            /*
             * // getting the beans using the type of the bean
             * // in this case the interface GamingConsole
             * // calling the up method on the bean which is being returned back.
             */
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

    }
}
