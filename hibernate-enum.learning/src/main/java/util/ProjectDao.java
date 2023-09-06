package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Project;

public class ProjectDao {
	 public void saveProject(Project project) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            Transaction transaction = session.beginTransaction();
	            // save the project object
	            session.persist(project);
	            // commit transaction
	            transaction.commit();
	        }
	    }

	    public List < Project > getProjects() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Project", Project.class).list();
	        }
	    }
}
