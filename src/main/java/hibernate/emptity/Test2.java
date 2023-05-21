package hibernate.emptity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();




        try {
            //ADD EMPLOYEE FROM DB
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg","Sidorov","HR",200);
            session.beginTransaction();//Begins session
            session.save(employee);//insert obj in base; Do something.
//            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.

            //GET EMPLOYEE FROM DB
            int myId = employee.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();//Begins session
            Employee employee1 = session.get(Employee.class,myId);
            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.
            System.out.println(employee1);

        }
      finally {
            factory.close();
        }
    }
}
