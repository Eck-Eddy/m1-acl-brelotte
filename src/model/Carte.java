package src.model;

import src.model.Couleur;
import src.model.Valeur;

public class Carte {

    private final Couleur color;
    private final Valeur valeur;
    private final int nbPoint;

    public Carte (final Couleur color, final Valeur val)
    {
        this.color = color;
        this.valeur = val;
        this.nbPoint = val.getValeur();
    }

    public Couleur getColor()
    {
        return color;
    }

    public Valeur getValeur()
    {
        return valeur;
    }

    public int getNbPoint()
    {
        return nbPoint;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "color=" + color +
                ", valeur=" + valeur +
                '}';
    }
}
