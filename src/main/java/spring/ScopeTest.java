package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Dog dog = context.getBean("dog",Dog.class);
        Dog your = context.getBean("dog",Dog.class);

        System.out.println(dog==your);
    }
}
