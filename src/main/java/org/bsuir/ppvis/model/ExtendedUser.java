package org.bsuir.ppvis.model;

import java.util.HashMap;
import java.util.Map;

public class ExtendedUser extends User{
    private final Map<Cutlery, Integer> cutleries;

    {
        cutleries = new HashMap<>();
    }

    public void addCultery(Cutlery cutlery, int amount) {
        if (cutleries.containsKey(cutlery)) {
            cutleries.replace(cutlery, cutleries.get(cutlery) + amount);
        } else {
            cutleries.put(cutlery, amount);
        }
    }

    public Map<Cutlery, Integer> getCutleries() {
        return cutleries;
    }
}
