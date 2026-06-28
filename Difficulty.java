
public class Difficulty {

    public static final Difficulty LEICHT = new Difficulty("LEICHT", 50, 8);
    public static final Difficulty MITTEL = new Difficulty("MITTEL", 100, 5);
    public static final Difficulty SCHWER = new Difficulty("SCHWER", 200, 4);

    private final String name;
    private final int range;
    private final int maxVersuche;

    private Difficulty(String name, int range, int maxVersuche) {
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

    public static Difficulty valueOf(String name) {
        
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

    public static Difficulty vonNummer(int nummer) {
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
