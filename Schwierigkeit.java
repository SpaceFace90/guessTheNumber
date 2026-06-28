
public class Schwierigkeit {

    public static final Schwierigkeit LEICHT = new Schwierigkeit("LEICHT", 50, 8);
    public static final Schwierigkeit MITTEL = new Schwierigkeit("MITTEL", 100, 5);
    public static final Schwierigkeit SCHWER = new Schwierigkeit("SCHWER", 200, 4);

    private final String name;
    private final int range;
    private final int maxVersuche;

    private Schwierigkeit(String name, int range, int maxVersuche) {
        this.name = name;
        this.range = range;
        this.maxVersuche = maxVersuche;
    }

    public int getRange() {
        return range;
    }

    public int getMaxVersuche() {
        return maxVersuche;
    }

    public String getName() {
        return name;
    }

    public static Schwierigkeit valueOf(String name) {
        
        switch (name) {
            case "LEICHT":
                return LEICHT;
            case "MITTEL":
                return MITTEL;
            case "SCHWER":
                return SCHWER;
            default:
                throw new IllegalArgumentException("Unbekannte Schwierigkeit: " + name);
        }
    }

    public static Schwierigkeit vonNummer(int nummer) {
        switch (nummer) {
            case 1:
                return LEICHT;
            case 2:
                return MITTEL;
            case 3:
                return SCHWER;
            default:
                throw new IllegalArgumentException("Unbekannte Schwierigkeit: " + nummer);
        }
    }
}
