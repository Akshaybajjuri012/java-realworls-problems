package junitdemo;

import org.junit.Test;
import static org.junit.Assert.*;


	class Student {
	    @SuppressWarnings("unused")
		private int id;
	    private String name;

	    public Student(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
	}
	interface StudentRepository {
	    Student findById(int id);
	}
	class StudentService {
	    private StudentRepository repository;

	    public StudentService(StudentRepository repository) {
	        this.repository = repository;
	    }

	    public String getStudentById(int id) {
	        Student student = repository.findById(id);
	        return student != null ? student.getName() : null;
	    }
	}
	public class StudentServiceTest {

		class FakeStudentRepository implements StudentRepository {
	        @Override
	        public Student findById(int id) {
	            if (id == 1) {
	                return new Student(1, "Alice");
	            }
	            return null;
	        }
	    }
	    
		@Test
	    public void testGetStudentById_ReturnsExpectedName() {
	        StudentRepository fakeRepo = new FakeStudentRepository();
	        StudentService studentService = new StudentService(fakeRepo);

	        String result = studentService.getStudentById(1);
	        assertEquals("Alice", result);
	    }

}
