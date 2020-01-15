package observatie;

import vogels.Habitat;
import vogels.TrekVogel;
import vogels.Vogel;

/**
 * PEER TUTORING
 * P2W6
 */

// gegeven, mag je wijzigen
public class GeobserveerdeVogel extends TrekVogel implements Identificeerbaar{

    // gegeven mag je niet wijzigen
    private String ringId;
    private String ringLocatie;
    private String observatie;

    // gegeven
    public GeobserveerdeVogel(String naam, Habitat habitat, String bestemming, String ringId, String ringLocatie) {
        super(naam, habitat, bestemming);
        this.ringId = ringId;
        this.ringLocatie = ringLocatie;
        this.observatie = "nihil";
    }

    @Override
    public String getRingInfo() {
        StringBuilder observatieGeformat = new StringBuilder(observatie);
        if (observatie.length() > 20) {
            observatieGeformat.setLength(20);
            observatieGeformat.append("...");
        }
        return String.format("ID: %-12s LOC: %-15s %-20s", ringId, ringLocatie, observatie.equalsIgnoreCase("nihil") ? "" : "OBS: \"" + observatieGeformat + "\"");
    }

    public String getObservatie() {
        return observatie;
    }

    public void setObservatie(String observatie) {
        this.observatie = observatie;
    }

    public String toString() {
        return String.format("%-20s %s", this.getNaam(), getRingInfo());
    }
}
