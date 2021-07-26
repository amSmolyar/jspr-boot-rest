package ru.netology.jsprbootrest;

import java.util.*;

import static ru.netology.jsprbootrest.Authorities.*;


public class UserRepository {
    private Map<String, String> userMap;
    private Map<String, List<Authorities>> authoritiesMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
        createUserMap();
        this.authoritiesMap = new HashMap<>();
        createAuthoritiesMap();
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        if (userMap.containsKey(user) && userMap.get(user).equals(password))
            list = authoritiesMap.get(user);

        return list;
    }

    private void createUserMap() {
        userMap.put("user1", "password1");
        userMap.put("Jack", "password2");
        userMap.put("Pavka", "password3");
        userMap.put("Ponchik", "password4");
        userMap.put("Stepka", "password5");
    }

    private void createAuthoritiesMap() {
        authoritiesMap.put("user1", List.of(READ));
        authoritiesMap.put("Jack", List.of(READ, WRITE, DELETE));
        authoritiesMap.put("Pavka", List.of(READ, WRITE));
        authoritiesMap.put("Ponchik", List.of(READ));
        authoritiesMap.put("Stepka", List.of(READ, WRITE, DELETE));
    }
}
