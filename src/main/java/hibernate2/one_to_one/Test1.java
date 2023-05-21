package hibernate2.one_to_one;

import hibernate2.one_to_one.emptity.Detail;
import hibernate2.one_to_one.emptity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session =null;

        try {
//             session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg","Smirnov","IT",300);
//            Detail detail = new Detail("Lviv", "1235121231","oleg@gmail.com");
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();//Begins session
//
//            session.save(employee);
//
//            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.

             session = factory.getCurrentSession();
            session.beginTransaction();//Begins session
            Employee employee = session.get(Employee.class,1);
            System.out.println(employee.getEmpDetail());

            session.delete(employee);

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.
        }
      finally {
            session.close();
            factory.close();
        }
    }
}
