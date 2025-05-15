package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Считывает данные о людях из CSV-файла и преобразует их в список объектов {@link Person}.
 * Формат CSV: id;name;gender;birthDate;division;salary
 * Пример строки: {@code 1;Иван Иванов;Male;15.05.1990;IT;50000.50}
 */
public class CsvReader {
    /**
     * Считывает данные из CSV-файла и преобразует их в список объектов {@link Person}.
     * Формат CSV: id;name;gender;birthDate;division;salary.
     * Некорректные строки пропускаются, ошибки выводятся в stderr.
     *
     * @param csvFilePath путь к CSV-файлу в ресурсах проекта
     * @return список объектов {@link Person} (может быть пустым, но не null)
     * @throws FileNotFoundException    если файл не найден
     * @throws CsvValidationException   при ошибках формата CSV
     * @throws IOException              при ошибках чтения файла
     */
    public List<Person> readPeopleFromCsv(String csvFilePath) throws IOException, CsvValidationException {
        List<Person> people = new ArrayList<>();
        char separator = ';';
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null :
                     new CSVReaderBuilder(new InputStreamReader(in, StandardCharsets.UTF_8))
                             .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                             .build()) {

            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try {
                    int id = Integer.parseInt(nextLine[0]);
                    String name = nextLine[1];
                    Gender gender = parseGender(nextLine[2]);
                    LocalDate birthDate = LocalDate.parse(nextLine[3], dateFormatter);
                    Department department = Department.getInstance(nextLine[4]);
                    double salary = Double.parseDouble(nextLine[5].replace(',', '.'));

                    people.add(new Person(id, name, gender, department, salary, birthDate));
                } catch (Exception e) {
                    System.err.println("Ошибка обработки строки: " + String.join(";", nextLine));
                    e.printStackTrace();
                }
            }
        }
        return people;
    }

    /**
     * Преобразует строковое значение пола в перечисление {@link Gender}.
     * Регистр значения игнорируется. Некорректные значения заменяются на {@link Gender#MALE}.
     *
     * @param genderStr строковое представление пола (например, "Male" или "Female")
     * @return соответствующее значение {@link Gender}
     */
    private Gender parseGender(String genderStr) {
        try {
            return Gender.valueOf(genderStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Некорректное значение пола: " + genderStr);
            return Gender.MALE; // значение по умолчанию
        }
    }
}
