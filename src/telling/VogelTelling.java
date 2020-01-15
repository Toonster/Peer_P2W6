package telling;

import observatie.GeobserveerdeVogel;
import observatie.Identificeerbaar;
import vogels.Vogel;

import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * PEER TUTORING
 * P2W6
 */

// gegeven, mag je wijzigen
public class VogelTelling {

    public class Overzicht {

        public void toonOverzicht() {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("DD/mm/YYYY HH:MM");
            System.out.printf("Vogeltelling op %s te %s\n", format.format(tijdstip), locatie);
            System.out.printf("Weertype: %s\n",weerType);
            System.out.println("-----------------------------------------------------");
            for (Map.Entry<Vogel, Integer> vogelIntegerEntry : tellingMap.entrySet()) {
                System.out.printf("%-20s %d\n",vogelIntegerEntry.getKey().getNaam(), vogelIntegerEntry.getValue());
            }
            System.out.println("-----------------------------------------------------");
            System.out.printf("Totaal: %d exemplaren, %d soorten\n", getAantalExemplaren(), getAantalVogelNamen());
            System.out.printf("Verhouding trekvogels: %.2f%%\n", getVerhoudingTrekVogels()*100);
            System.out.println("-----------------------------------------------------");
            System.out.print("Logboek Ringinfo:");
            System.out.println(logBoek);
        }

    }


    // gegeven mag je niet wijzigen
    private String locatie;
    private LocalDateTime tijdstip;
    private String weerType;
    private String logBoek;
    private Map<Vogel, Integer> tellingMap;

    // gegeven mag je wijzigen
    public VogelTelling(String locatie, LocalDateTime tijdstip, String weerType) {
        if (LocalDateTime.now().isBefore(tijdstip)) {
            throw new DateTimeException("Time can't be in the future");
        }
        this.locatie = locatie;
        this.tijdstip = tijdstip;
        this.weerType = weerType;
        this.logBoek = "";
        this.tellingMap = new TreeMap<>();
    }

    // gegeven mag je wijzigen
    public void voegVogelToe(Vogel vogel, int aantal) {
        if (vogel instanceof Identificeerbaar) {
            this.logBoek = logBoek + "\n" + ((Identificeerbaar) vogel).getRingInfo();
        }
        if (tellingMap.containsKey(vogel)) {
            int amount = tellingMap.get(vogel);
            tellingMap.put(vogel, aantal + amount);
            return;
        }
        tellingMap.put(vogel, aantal);
    }

    // gegeven mag je wijzigen
    public int getAantalExemplaren() {
        int totaal = 0;
        for (int value : tellingMap.values()) {
            totaal += value;
        }
        return totaal;
    }

    // gegeven mag je wijzigen
    public int getAantalVogelNamen() {
        return tellingMap.keySet().size();
    }

    // gegeven mag je wijzigen
    public double getVerhoudingTrekVogels() {
        double totaalTrekkers = 0;
        for (Vogel vogel : tellingMap.keySet()) {
            if (vogel.isTrekker()) {
                totaalTrekkers+=tellingMap.get(vogel);
            }
        }
        return totaalTrekkers/getAantalExemplaren();
    }
}
