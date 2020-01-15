package vogels;

import java.util.Objects;

/**
 * PEER TUTORING
 * P2W6
 */

// gegeven, mag je wijzigen
public abstract class Vogel implements Comparable<Vogel>{

    // gegeven, mag je niet wijzigen
    private String naam;
    private Habitat habitat;

    // gegeven, mag je niet wijzigen
    public Vogel(String naam, Habitat habitat) {
        this.naam = naam;
        this.habitat = habitat;
    }

    @Override
    public int compareTo(Vogel vogel) {
        return this.naam.compareTo(vogel.naam);
    }

    public boolean isTrekker() {
        return false;
    }

    public String verblijftIn() {
        return this.habitat.name().toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("%-20s habitat: %-12s", naam, verblijftIn());
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vogel vogel = (Vogel) o;
        return Objects.equals(naam, vogel.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }
}
