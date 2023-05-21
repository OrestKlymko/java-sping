package spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Hello world!
 *
 */

//@Component

public class Dog implements Pet{
    private String name;

    public Dog(){
        System.out.println("Dog bean is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println( "HOW HOW" );
    }
//
//@PostConstruct
//    private void init(){
//        System.out.println("Class: init method");
//
//    }
//@PreDestroy
//    private void destroy(){
//        System.out.println("Class: destroy method");
//    }

}
