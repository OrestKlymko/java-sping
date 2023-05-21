package hibernate.emptity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();




        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();//Begins session
//            Employee employee = session.get(Employee.class,3);//get ID Employee
//
//            session.delete(employee);

            session.createQuery("DELETE Employee WHERE name='Oleg'").executeUpdate(); // 2 moznost

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.


        }
      finally {
            factory.close();
        }
    }
}
