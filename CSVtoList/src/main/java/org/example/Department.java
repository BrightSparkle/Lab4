package org.example;
import java.util.HashMap;
import java.util.Map;

public class Department {
    private static final Map<String, Department> departments = new HashMap<>();
    private static int nextId = 1;

    private final int id;
    private final String name;

    private Department(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public static Department getInstance(String name) {
        departments.putIfAbsent(name, new Department(name));
        return departments.get(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }

    public static void reset() {
        departments.clear();
        nextId = 1;
    }
}
