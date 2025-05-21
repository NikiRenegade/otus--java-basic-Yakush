package hw11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap = new HashMap<>();

    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    public Person findById(long id) {
        return personMap.get(id);
    }

    public boolean isManager(Person person) {
        return person.isManager();
    }
    public boolean isEmployee(Person person) {
        return !person.isManager();
    }
}
