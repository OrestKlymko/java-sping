package hibernate.emptity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();




        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();//Begins session
            Employee employee = session.get(Employee.class,1);//get ID Employee
            employee.setSalary(1500);//Set new salary

            session.createQuery("UPDATE Employee SET salary=100 WHERE name='Olena'").executeUpdate();//2 moznost

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.


        }
      finally {
            factory.close();
        }
    }
}
