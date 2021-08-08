package ru.netology.jsprbootrest;

import java.util.*;

import static ru.netology.jsprbootrest.Authorities.*;


public class UserRepository {
    private Map<User, List<Authorities>> authoritiesMap;

    public UserRepository() {
        this.authoritiesMap = new HashMap<>();
        createAuthoritiesMap();
    }

    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> list = new ArrayList<>();
        if (authoritiesMap.containsKey(user))
            list = authoritiesMap.get(user);

        return list;
    }

    private void createAuthoritiesMap() {
        authoritiesMap.put(new User("user1", "password1"), Arrays.asList(READ));
        authoritiesMap.put(new User("Jack", "password2"), Arrays.asList(READ, WRITE, DELETE));
        authoritiesMap.put(new User("Pavka", "password3"), Arrays.asList(READ, WRITE));
        authoritiesMap.put(new User("Ponchik", "password4"), Arrays.asList(READ));
        authoritiesMap.put(new User("Stepka", "password5"), Arrays.asList(READ, WRITE, DELETE));
    }
}
