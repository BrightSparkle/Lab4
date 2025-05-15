import org.example.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {
    @BeforeEach
    void reset() {
        Department.reset();
    }

    @Test
    void testGetInstanceSameNameReturnsSameInstance() {
        Department dept1 = Department.getInstance("G");
        Department dept2 = Department.getInstance("G");
        assertSame(dept1, dept2);
    }

    @Test
    void testGetInstanceDifferentNamesReturnDifferentInstances() {
        Department dept1 = Department.getInstance("I");
        Department dept2 = Department.getInstance("O");
        assertNotSame(dept1, dept2);
    }

    @Test
    void testDepartmentIdsAreIncremented() {
        Department dept1 = Department.getInstance("I");
        Department dept2 = Department.getInstance("G");
        assertEquals(1, dept1.getId());
        assertEquals(2, dept2.getId());
    }
}
