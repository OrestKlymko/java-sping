package hibernate.emptity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();




        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();//Begins session
            List<Employee> employees = session.createQuery("FROM Employee WHERE name='Orest'").getResultList();//Employee its a name of CLASS Employee.class

            for (Employee e : employees) {
                System.out.println(e);
            }

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.


        }
      finally {
            factory.close();
        }
    }
}
