package many_to_many.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Section section2 = new Section("Dz udo");
//            Section section3 = new Section("Volleyball");
//
//            Child child1 = new Child("Oleg", 3);
//
//
//           child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//
//            session.beginTransaction();
//
//
//            session.save(child1);
//            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
