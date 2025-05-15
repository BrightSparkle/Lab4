package org.example;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, представляющий подразделение в организации.
 * Гарантирует уникальность экземпляров для каждого названия подразделения.
 */
public class Department {
    /**
     * Карта для хранения существующих подразделений. Ключ — название подразделения.
     */
    private static final Map<String, Department> departments = new HashMap<>();
    /**
     * Счетчик для генерации уникальных идентификаторов подразделений.
     */
    private static int nextId = 1;

    private final int id;
    private final String name;

    private Department(String name) {
        this.id = nextId++;
        this.name = name;
    }

    /**
     * Возвращает экземпляр подразделения. Если подразделение с указанным названием уже существует,
     * возвращает существующий экземпляр. В противном случае создает новый.
     *
     * @param name название подразделения (не должно быть null или пустым)
     * @return экземпляр {@link Department}
     * @throws IllegalArgumentException если name равен null или пустой строке
     */
    public static Department getInstance(String name) {
        departments.putIfAbsent(name, new Department(name));
        return departments.get(name);
    }

    /**
     * Возвращает уникальный идентификатор подразделения.
     * @return ID подразделения
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название подразделения.
     * @return название подразделения
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }

    /**
     * Сбрасывает внутренний кэш подразделений и счетчик ID.
     * Используется ТОЛЬКО для тестирования.
     */
    public static void reset() {
        departments.clear();
        nextId = 1;
    }
}
