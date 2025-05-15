import org.example.*;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {
    private CsvReader csvReader;

    @BeforeEach
    void setUp() {
        csvReader = new CsvReader();
        Department.reset();
    }

    @Test
    void testReadValidCsvFile() throws IOException, CsvValidationException {
        List<Person> people = csvReader.readPeopleFromCsv("foreign_names.csv");
        assertEquals(25898, people.size());

        Person first = people.get(0);
        assertEquals(28281, first.getId());
        assertEquals("Aahan", first.getName());
        assertEquals(Gender.MALE, first.getGender());
        assertEquals("I", first.getDepartment().getName());
        assertEquals(4800, first.getSalary());
        assertEquals(LocalDate.of(1970, 5, 15), first.getBirthDate());

        Person second = people.get(1);
        assertEquals(2600, second.getSalary()); // Проверка замены запятой
    }

    @Test
    void testInvalidDataIsSkipped() throws IOException, CsvValidationException {
        List<Person> people = csvReader.readPeopleFromCsv("test.csv");
        assertEquals(1, people.size()); // Одна корректная строка из двух
    }
}
