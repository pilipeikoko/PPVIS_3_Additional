package org.bsuir.ppvis.model;

import java.util.ArrayList;
import java.util.List;

public class AlergicUser extends User {
    private final List<Alergy> alergies;

    {
        alergies = new ArrayList<>();
    }

    public void addAlergy(Alergy alergy) {
        alergies.add(alergy);
    }

    public List<Alergy> getAlergies() {
        return alergies;
    }
}