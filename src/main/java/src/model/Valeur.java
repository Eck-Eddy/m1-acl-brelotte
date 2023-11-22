package src.model;

public enum Valeur {

    AS(11),
    ROI(4),
    DAME(3),
    VALET(2),
    DIX(10),
    NEUF(9),
    HUIT(8),
    SEPT(7);

    private final int valeur;

    Valeur(int i) {
        this.valeur = i;
    }

    public int getValeur()
    {
        return valeur;
    }


}
