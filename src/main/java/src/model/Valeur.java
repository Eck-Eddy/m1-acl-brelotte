package src.model;

/**
 * classe Valeur qui enumère les valeurs possibles
 */
public enum Valeur {

    AS(11),
    ROI(4),
    DAME(3),
    VALET(2),
    DIX(10),
    NEUF(9),
    HUIT(8),
    SEPT(7);

    /**
     * Variable de la classe Valeur
     */
    private final int valeur;

    /**
     * constructeur d'une Valeur
     * @param i
     */
    Valeur(int i) {
        this.valeur = i;
    }

    /**
     *
     * @return <code>valeur</code> retourne la valeur d'une Valeur
     */
    public int getValeur()
    {
        return valeur;
    }


}
