import java.util.Random;
import java.util.Scanner;
 
public class Game {
 
    private int spielerVersuche;
    private int guess;
    private int zielZahl;
    private String hint;
    private Difficulty difficulty;
 
    public void spielen() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
 
        System.out.println("Schwierigkeit waehlen (LEICHT, MITTEL, SCHWER): ");
 
        zielZahl = random.nextInt(difficulty.getRange()) + 1;
 
        //spielerVersuche = 0;
        //guess = 0;
 
        System.out.println("Ich denke an eine Zahl zwischen 1 und " + difficulty.getRange() + ".");
        System.out.println("Du hast " + difficulty.getMaxVersuche() + " Versuche.");
 
        while (true) {
            System.out.print("Dein Tipp: ");
            guess = scanner.nextInt();
            spielerVersuche++;
 
            if (guess == zielZahl) {
                System.out.println("Richtig! Du hast " + spielerVersuche + " Versuche gebraucht.");
                break;
            }
 
            if (spielerVersuche >= difficulty.getMaxVersuche()) {
                System.out.println("You Lose, du hast die maximale Anzahl von " + difficulty.getMaxVersuche() + " gebraucht.\n" +
                        "Die richtige Zahl war " + zielZahl);
                break;
            }
 
            if (guess < zielZahl) {
                hint = "Zu klein";
            } else {
                hint = "Zu gross";
            }
            System.out.println(hint);
        }
 
        scanner.close();
    }
 
    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }
}
 
 
