package org.example;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

/**
 * Основной класс приложения для демонстрации работы с CSV-данными.
 */
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        try {
            List<Person> people = csvReader.readPeopleFromCsv("foreign_names.csv");
            people.forEach(System.out::println);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}