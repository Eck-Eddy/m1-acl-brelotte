package src.model;

import javafx.scene.image.Image;
import src.model.Couleur;
import src.model.Valeur;

import java.io.IOException;
import java.net.URL;

public class Carte {

    private String nom;
    private final Couleur color;
    private final Valeur valeur;
    private final Categorie categorie;
    private final int nbPoint;
    private Image image;

    public Carte (String name,final Couleur color,final Categorie cat, final Valeur val)
    {
        setNom(name);
        this.color = color;
        this.valeur = val;
        this.nbPoint = val.getValeur();
        this.categorie = cat;

    }


    public void setNom(String name) {
        if (name == null || name.trim().isEmpty())
        {
            System.err.println("Erreur le nom de la carte n'est pas conforme");
            throw new IllegalArgumentException("Erreur le nom de la carte n'est pas conforme");
        }
        else
        {
            nom = name;
        }
    }

    public String getNom(){return nom;}

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

    public Categorie getCategorie(){return  categorie;}

    @Override
    public String toString() {
        return "Carte{" +
                "color=" + color +
                ", valeur=" + valeur +
                '}';
    }
}
