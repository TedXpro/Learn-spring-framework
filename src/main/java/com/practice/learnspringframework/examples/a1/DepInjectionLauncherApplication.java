package com.practice.learnspringframework.examples.a1;

import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourbusinessClass {

    // @Autowired // Field injection.
    Dependency1 dependency1;
    // @Autowired // Field injection.
    Dependency2 dependency2;

    // @Autowired // Constructor injection.
    public YourbusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();

        System.out.println("Constructor Injection - Your Business class");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // @Autowired // setter injection
    // public void setDependency1(Dependency1 dependency1) {
    //     System.out.println("Setter injection. - setDependency1");
    //     this.dependency1 = dependency1;
    // }

    // @Autowired
    // public void setDependency2(Dependency2 dependency2) {
    //     System.out.println("Setter injection. - setDependency2");
    //     this.dependency2 = dependency2;
    // }

    public String toString() {
        return "using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).
                    forEach(System.out::println);
            System.out.println(context.getBean(YourbusinessClass.class));
        }

    }
}
