package projet.projetacl;

/**
 * Classe qui gère le passage de données entre les pages
 */
public class DataSingleton {

    private static final DataSingleton instance = new DataSingleton();

    private String scoreFinal;

    /**
     * constructeur du singleton
     */
    private DataSingleton(){}

    /**
     * fonction qui retourne l'instance du singleton
     * @return
     */
    public static DataSingleton getInstance()
    {
        return instance;
    }

    /**
     * procédure qui donne le score final de la partie
     * @return
     */
    public String getScoreFinal()
    {
        return scoreFinal;
    }

    /**
     * procédure qui modifie le score final de la partie
     * @param score
     */
    public void setScoreFinal(String score)
    {
        this.scoreFinal=score;
    }
}
