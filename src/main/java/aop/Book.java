package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Name of book")
    private String name;
    @Value("Klymko")
    private String author;
    @Value("1997")
    private int yearPub;

    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPub() {
        return yearPub;
    }
}
