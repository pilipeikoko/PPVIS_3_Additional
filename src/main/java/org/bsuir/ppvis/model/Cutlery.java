package org.bsuir.ppvis.model;

public class Cutlery {
    private final String name;

    public Cutlery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return 11 * name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        Cutlery cult = (Cutlery) o;

        return cult.name.equals(this.name);
    }
}