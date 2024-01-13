package test;

import src.model.Carte;
import src.model.Categorie;
import src.model.Couleur;
import src.model.Valeur;

public class testCarte {
    public static void main(String[] args)
    {

        Carte c = new Carte("test",Couleur.ROUGE, Categorie.TREFLE,Valeur.HUIT);

        System.out.println("La carte construite : "+c.toString());

        //test nom
        System.out.println("\n Le nom de la carte est : "+c.getNom());

        //test couleur
        System.out.println("\nLa couleur de la carte est : "+c.getColor());
        //test valeur
        System.out.println("\nLa valeur de la carte est : "+c.getValeur());
        //test nombre point
        System.out.println("\nLe nombre de point de la carte est : "+c.getNbPoint());
        //test categorie
        System.out.println("\nLa categorie de la carte est : "+c.getCategorie());

    }
}
