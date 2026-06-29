import java.util.Random;
import java.util.Scanner;
 
public class Game {
 
    //private int spielerVersuche;
    //private int guess;
    private Spieler spieler;
    private int zielZahl;
    private String hint;
    private Schwierigkeit schwierigkeit;


     public Game(Spieler spieler, Schwierigkeit schwierigkeit){

        this.spieler = spieler;
        this.schwierigkeit = schwierigkeit;
    }

     public static int askDifficultyNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Schwierigkeit waehlen:");
        System.out.println("1 = LEICHT");
        System.out.println("2 = MITTEL");
        System.out.println("3 = SCHWER");
        System.out.print("Deine Wahl: ");

        return scanner.nextInt();
    }
 
    public void spielen() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        zielZahl = random.nextInt(schwierigkeit.getRange()) + 1;
 

        while (schwierigkeit == null) {
            int wahl = scanner.nextInt();
            if (wahl == 1 || wahl == 2 || wahl == 3) {
                schwierigkeit = Schwierigkeit.vonNummer(wahl);
            } else {
                System.out.println("Ungueltige Wahl. Bitte 1, 2 oder 3 eingeben: ");
            }
        }
 
        
        System.out.println();
        System.out.println("Spiel startet!");
        System.out.println("Ich denke an eine Zahl zwischen 1 und " + schwierigkeit.getRange() + ".");
        System.out.println("Du hast " + schwierigkeit.getMaxVersuche() + " Versuche.");
        System.out.println();
 
        while (true) {

            System.out.println("Versuch " + (spieler.getVersuche() + 1) + " von " + schwierigkeit.getMaxVersuche());
            System.out.print("Dein Tipp: ");
            

            spieler.setGuess(scanner.nextInt());
            spieler.versucheErhoehen();
            System.out.println();
 
            if (spieler.getGuess() == zielZahl) {
                System.out.println("Richtig! Du hast " + spieler.getVersuche() + " Versuche gebraucht.");
                break;
            }
 
            if (spieler.getVersuche() >= schwierigkeit.getMaxVersuche()) {

                System.out.println("You Lose!");
                System.out.println("du hast die maximale Anzahl von " + schwierigkeit.getMaxVersuche() + " Versuchen erreicht.");
            
                System.out.println("Die richtige Zahl war " + zielZahl + ".");
                break;
            }
 
            if (spieler.getGuess() < zielZahl) {
                hint = "Zu klein";
            } 
            
            else {
                hint = "Zu gross";
            }

            System.out.println(hint);
            System.out.println();
        }
 
        scanner.close();
    }
 
    public static void main(String[] args) {

        int schwierigkeitsNummer = askDifficultyNumber();
        
        Schwierigkeit schwierigkeit = Schwierigkeit.vonNummer(schwierigkeitsNummer);

        Spieler spieler = new Spieler("Anes");

        Game spiel = new Game(spieler, schwierigkeit);
        spiel.spielen();
    }
}
 