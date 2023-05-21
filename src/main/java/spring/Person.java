package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("personBean")
@Scope("prototype")
@Component
public class Person {

    private Pet pet;
    @Value("${person.age}")
    private int age;
    private String surname;

    public int getAge() {
        return age;
    }

//    @Autowired
//
//    public Person(@Qualifier("catBean") Pet pet) {
//        System.out.println("Person constructor bean");
//        this.pet = pet;
//    }


//
    @Autowired

    public Person(@Qualifier("personBean") Pet pet) {
        System.out.println("Person constructor bean");
        this.pet = pet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
//    @Autowired
//    @Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("Class person: set pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello, my pet");
        pet.say();
    }
}
