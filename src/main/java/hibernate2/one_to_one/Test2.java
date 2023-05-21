package hibernate2.one_to_one;

import hibernate2.one_to_one.emptity.Detail;
import hibernate2.one_to_one.emptity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session =null;

        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Misha","Ivanov","HE",2200);
//            Detail detail = new Detail("New York", "121231","misha@gmail.com");
//
//            employee.setEmpDetail(detail);//we need it because without this foreign key will be null for BI One-to-One relationship
//            detail.setEmployee(employee);
//
//            session.beginTransaction();//Begins session
//
//            session.save(detail);
//
//            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.

            session = factory.getCurrentSession();

            session.beginTransaction();//Begins session

            Detail detail = session.get(Detail.class,4);
            session.delete(detail);

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.


        }
      finally {
            session.close();
            factory.close();
        }
    }
}
