package hibernate.test2.emptity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {
            Employee employee = new Employee("Kostia","Demydov","IT",400);
            session.beginTransaction();//Begins session
            session.save(employee);//insert obj in base; Do something.
            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.
        }
      finally {
            factory.close();
        }
    }
}
