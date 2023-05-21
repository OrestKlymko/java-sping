package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{

    public void getBook(){
        System.out.println("We take book UniLibrary: ");
        System.out.println("------------------------------------------");
    }

    public void returnBook(){
        System.out.println("We return book in UniLibrary");
        System.out.println("------------------------------------------");
    }
    public void getMagazine(){
        System.out.println("We take getMagazine in UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("We return getMagazine in UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void addBook(String person, Book book){
        System.out.println("We add book in UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("We add magazine in UniLibrary");
        System.out.println("------------------------------------------");
    }






}
