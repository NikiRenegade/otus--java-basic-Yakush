package hw10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneMap = new HashMap<>();

    public void add(String name, String phoneNumber) {
        if (!phoneMap.containsKey(name)) {
            phoneMap.put(name, new HashSet<>());
        }
        phoneMap.get(name).add(phoneNumber);
    }

    public Set<String> find(String name) {
        return phoneMap.get(name);
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (var numbers : phoneMap.values()) {
            if (numbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
