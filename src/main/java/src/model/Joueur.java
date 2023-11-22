package src.model;

public class Joueur {

    private String Pseudonyme;
    private int points;

    public Joueur(String pseudonyme)
    {
        setPseudonyme(pseudonyme);
        setPoints(0);
    }

    public Joueur(String pseudonyme, int points) {
        setPseudonyme(pseudonyme);
        setPoints(points);
    }

    public String getPseudonyme() {
        return Pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        if (pseudonyme == null || pseudonyme.trim().isEmpty())
        {
            System.err.println("Erreur le pseudonyme n'est pas conforme");
            throw new IllegalArgumentException("Erreur le pseudonyme n'est pas conforme");
        }
        else
        {
            Pseudonyme = pseudonyme;
        }

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
