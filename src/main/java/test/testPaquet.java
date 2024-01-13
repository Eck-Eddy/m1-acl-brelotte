package test;

import src.model.*;

import static src.model.Categorie.COEUR;

public class testPaquet {

    public static void main(String[] args)
    {
        Paquet p = new Paquet();

        //test si getCartes fonctionne
        System.out.println("affiche toute les cartes : ");
        System.out.println(p.getCartes()+"\n");

        //test getCartes(int i)
        System.out.println("affiche la carte 3 du paquet");
        System.out.println(p.getCartes(2)+"\n");

        //test getCartes(String i)
        System.out.println("affiche la carte avec le nom dameCoeur");
        System.out.println(p.getCartes("dameCoeur"));

        //test nbCarte
        System.out.println("\n affichage du nombre de carte du paquet : "+p.nbCarte()+"\n");

        //test addCarte
        System.out.println("Ajout d'une nouvelle carte Test dans le Paquet");
        Carte c = new Carte("test", Couleur.ROUGE, COEUR, Valeur.AS);
        p.addCarte(c);
        System.out.println("nombre de Cartes après ajout : "+p.nbCarte());
        System.out.println(p.getCartes("test"));


    }
}
