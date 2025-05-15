import org.example.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonConstructorAndGetters() {
        Department department = Department.getInstance("IT");
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        Person person = new Person(1, "Иван Иванов", Gender.MALE, department, 50000.50, birthDate);

        assertEquals(1, person.getId());
        assertEquals("Иван Иванов", person.getName());
        assertEquals(Gender.MALE, person.getGender());
        assertSame(department, person.getDepartment());
        assertEquals(50000.50, person.getSalary());
        assertEquals(birthDate, person.getBirthDate());
    }
}