package mydaofiles;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.student_123;
public class StudentDao {
	 private SessionFactory factory;

	    public StudentDao() {
	        factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();
	    }

	    //INSERT
	    public void addStudent(student_123 student)
	    {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(student);//SAVING OBJECT=>INSERT INTO TABLENAME VALUES
	        tx.commit();
	        session.close();   
	    }
	    
	    public boolean updatestudent(student_123 student) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        student_123 existing = (student_123) session.get(student_123.class, student.getId());//SELECT SPECIFIC RECORD
	        if (existing != null) {
	            existing.setName(student.getName());
	            existing.setEmail(student.getEmail());
	            session.update(existing);//UPDATE TABLENAME SET COLUMNNAME=VALUE
	            tx.commit();
	            
	            session.close();
	            return true;
	        } else {
	            session.close();
	            return false;
	        }
	    }
	    public boolean deletestudent(int id) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            student_123 student = (student_123) session.get(student_123.class, id);//SELECT SPECIFIC RECORD
            if (student != null) {
                session.delete(student);//DELETE FROM STUDENT WHERE STUDID=?
                tx.commit();    	
            	session.close();
                return true;
            } else {
                session.close();
                return false;
            }
        }
	    public student_123 getstudent(int id) {
            Session session = factory.openSession();
            student_123 student = (student_123) session.get(student_123.class, id);//SELECT SPECIFIC RECORD
            session.close();
            return student;
        }
        
        @SuppressWarnings("unchecked")
		public List<student_123> getAllstudents() {
            Session session = factory.openSession();
            List<student_123> list = session.createQuery("from student_123").list();  // HQL /JPQL Hibernate 4.3 style
            session.close();//from Student_123 => from Entityclass/Pojoclass (NO TABLENAME/RAW SQL COMMAND)
            return list;
        }

}
