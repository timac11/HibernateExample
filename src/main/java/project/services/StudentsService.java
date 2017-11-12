package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import project.entities.StudentsEntity;
import project.utils.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsService {

    public void addStudent(StudentsEntity student) throws SQLException {
        try (SessionFactory  sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.OK_OPTION);
        }
    }

    public List<StudentsEntity> getAllStudents() {
        Session session = null;
        List<StudentsEntity> studentsEntities = new ArrayList<StudentsEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String query = "FROM StudentsEntity";
            studentsEntities = session.createQuery(query).list();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                HibernateUtil.getSessionFactory().close();
                System.out.println("session is closed");
            }
        }
        return studentsEntities;
    }
}
