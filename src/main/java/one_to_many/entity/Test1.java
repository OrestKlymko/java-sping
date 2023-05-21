package one_to_many.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new  Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session =null;

        try {
//
//             session = factory.getCurrentSession();
//
//
//            Department department = new Department("IT",500,40000);
//            Employee employee = new Employee("Oleh","Orest",40000);
//            Employee employee1 = new Employee("Igor","nazar",1000);
//            department.addEmployeeToDepartment(employee);
//            department.addEmployeeToDepartment(employee1);
//
//            session.beginTransaction();//Begins session
//            session.save(department);
//            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.

//******************************************************************************************************************************************
            session = factory.getCurrentSession();

            session.beginTransaction();//Begins session

            Employee employee = session.get(Employee.class,3);
            Department department = session.get(Department.class,2);

            System.out.println(department.getEmployeeList());

            session.getTransaction().commit();//push to db and close transaction. EVERY TIME WE NEED IT.
        }
      finally {
            session.close();
            factory.close();
        }
    }
}
