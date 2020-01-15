package vogels;

/**
 * PEER TUTORING
 * P2W6
 */

// gegeven, mag je wijzigen
public class TrekVogel extends Vogel {

    private final String bestemming;

    public TrekVogel(String naam, Habitat habitat, String bestemming) {
        super(naam, habitat);
        this.bestemming = bestemming;
    }

    @Override
    public boolean isTrekker() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s --> trekt naar %s", super.toString(), bestemming);
    }
}
