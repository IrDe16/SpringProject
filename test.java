package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()

                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Irina", "Denman", "IT",);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
