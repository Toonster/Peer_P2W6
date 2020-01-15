package vogels;

/**
 * PEER TUTORING
 * P2W6
 */

// gegeven, mag je wijzigen
public final class StandVogel extends Vogel{

    private final String wintergedrag;

    public StandVogel(String naam, Habitat habitat, String wintergedrag) {
        super(naam, habitat);
        this.wintergedrag = wintergedrag;
    }
}
