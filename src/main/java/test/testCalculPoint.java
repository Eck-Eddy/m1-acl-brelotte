package test;

import src.model.Carte;
import src.model.Jeu;
import src.model.Joueur;
import src.model.Paquet;

import java.util.ArrayList;

public class testCalculPoint {

    public static void main(String[] args)
    {

        Joueur j= new Joueur("arthur");
        Jeu game = new Jeu(j);

        int i;
        for(i=0;i<5;i++)
        {
            //on effectue le tirage des deux cartes
            ArrayList<Carte> tirage1 = game.getPaquetCarte().tirage2Cartes();

            //on calcul les points du tirage
            game.calculPoint(tirage1,game);

            System.out.println("Affichage des cartes tirées :");
            System.out.println (tirage1);
            System.out.println("Règles qui s'applique à ce tirage : ");

            //couleur et valeur différente
            if (tirage1.get(0).getValeur() != tirage1.get(1).getValeur() && tirage1.get(0).getColor() != tirage1.get(1).getColor())
            {
                System.out.println("On ajoute au score du joueur la somme des valeurs des deux cartes ");
            }

            //meme valeur mais couleur differente
            else if (tirage1.get(0).getValeur() == tirage1.get(1).getValeur() && tirage1.get(0).getColor() != tirage1.get(1).getColor())
            {
                System.out.println("On soustrait au score du joueur la somme des valeurs des deux cartes ");
            }

            //meme couleur et meme valeur
            else if (tirage1.get(0).getValeur() == tirage1.get(1).getValeur() && tirage1.get(0).getColor() == tirage1.get(1).getColor())
            {
                System.out.println("On soustrait au score du joueur le double de la somme des valeurs des deux cartes ");
            }
            else
            {
                System.out.println("on ne fait rien dans ce cas présent");
            }

            System.out.println("points du tirage : "+game.getPointTour()+", nbPoint joueur : "+j.getPoints()+"\n");

        }

    }
}
