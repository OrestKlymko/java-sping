package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet",Dog.class);
        Dog yourDog = context.getBean("myPet",Dog.class);
        myDog.setName("Levko");
        yourDog.setName("Marko");
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());

    }



}
