package src.model;

/**
 * Classe Joueur qui représente un joueur d'une partie
 */
public class Joueur {

    /**
     * String qui contient le Pseudonyme du joueur
     */
    private String Pseudonyme;

    /**
     * entier qui contient le nombre de points du joueur
     */
    private int points;

    /**
     * Constructeur d'un Joueur avec mise à 0 automatique du nombre de points
     * @param pseudonyme nom qui sera affecté au joueur durant la partie
     */
    public Joueur(String pseudonyme)
    {
        setPseudonyme(pseudonyme);
        setPoints(0);
    }

    /**
     * Constructeur d'un joueur
     * @param pseudonyme nom du joueur
     * @param points si l'on souhaite attribué un nombre de points dès le départ
     */
    public Joueur(String pseudonyme, int points) {
        setPseudonyme(pseudonyme);
        setPoints(points);
    }

    /**
     * Donne le Pseudonyme du joueur
     * @return le pseudonyme du joueur
     */
    public String getPseudonyme() {
        return Pseudonyme;
    }

    /**
     * Permet de modifier le Pseudonyme du joueur
     * @param pseudonyme nom du joueur
     * @throws IllegalArgumentException Si le nom n'est pas conforme
     */
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

    /**
     * Donne le nombre de points que le joueur possède
     * @return le nombre de points que le joueur a acquis
     */
    public int getPoints() {
        return points;
    }

    /**
     * Permet de modifier le nombre de points que le joueur possède
     * @param points nombre de points que l'on veut attribué au joueur
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
