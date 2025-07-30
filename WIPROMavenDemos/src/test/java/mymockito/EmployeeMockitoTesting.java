package mymockito;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeMockitoTesting {

    private static EmployeeDAO mockEmployeeDAO;
    private static Employee emp1;
    private static Employee emp2;

    @BeforeClass
    public static void init() {
        mockEmployeeDAO = Mockito.mock(EmployeeDAO.class);

        emp1 = new Employee(1001L, "Raja", "Male", 4);
        emp2 = new Employee(1002L, "Thananya", "Female", 7);

        when(mockEmployeeDAO.getAll()).thenReturn(Arrays.asList(emp1, emp2));
        when(mockEmployeeDAO.getEmployee(1001L)).thenReturn(emp1);
        when(mockEmployeeDAO.addEmployee(emp2)).thenReturn(emp2.getEmployeeName());
        when(mockEmployeeDAO.updateEmployee(emp2)).thenReturn(emp2.getEmployeeName());

        when(mockEmployeeDAO.deleteEmployee(1001L)).thenReturn("DELETED").thenReturn("REMOVED");

        when(mockEmployeeDAO.getPoints(1001L)).thenReturn(2, 4, 9);
        when(mockEmployeeDAO.getPoints(1002L)).thenReturn(0);
    }

    @Test
    public void getAllTest() {
        List<Employee> allEmployees = mockEmployeeDAO.getAll();
        assertNotNull(allEmployees);
        assertEquals(2, allEmployees.size());
    }

    @Test
    public void getEmployeeTest() {
        Long employeeId = 1001L;
        Employee employee = mockEmployeeDAO.getEmployee(employeeId);
        assertNotNull(employee);
        assertEquals(Long.valueOf("1001"), employee.getEmployeeId());
        assertEquals("Raja", employee.getEmployeeName());
        assertEquals("Male", employee.getGender());
    }

    @Test
    public void addEmployeeTest() {
        String employeeName = mockEmployeeDAO.addEmployee(emp2);
        assertNotNull(employeeName);
        assertEquals("Thananya", employeeName);
    }

    @Test
    public void deleteEmployeeTest() {
        String status1 = mockEmployeeDAO.deleteEmployee(1001L);
        assertEquals("DELETED", status1);

        String status2 = mockEmployeeDAO.deleteEmployee(1001L);
        assertEquals("REMOVED", status2);
    }

    @Test
    public void multipleCallsTest() {
        System.out.println(mockEmployeeDAO.getPoints(1001L)); // 2
        System.out.println(mockEmployeeDAO.getPoints(1002L)); // 0
        System.out.println(mockEmployeeDAO.getPoints(1001L)); // 4
        System.out.println(mockEmployeeDAO.getPoints(1001L)); // 9
        System.out.println(mockEmployeeDAO.getPoints(1001L)); // 9
    }
}
