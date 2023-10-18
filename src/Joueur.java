package src;

public class Joueur {

    String Pseudonyme;
    int points;

    public Joueur(String pseudonyme, int points) {
        Pseudonyme = pseudonyme;
        this.points = points;
    }

    public String getPseudonyme() {
        return Pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        if (pseudonyme == null || pseudonyme.trim().isEmpty())
        {
            System.err.println("Erreur le pseudonyme n'est pas conforme");
            System.exit(1);
        }
        Pseudonyme = pseudonyme;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
