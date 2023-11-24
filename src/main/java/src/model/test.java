package src.model;

import java.util.ArrayList;

public class test {

    public static void main(String[] args)
    {
        Paquet p = new Paquet();

            //System.out.println (p.tirage2Cartes());

            Joueur j= new Joueur("arthur");
            Jeu game = new Jeu(j);
        ArrayList<Carte> tirage1 = p.tirage2Cartes();
            game.calculPoint(tirage1,game);
        System.out.println (tirage1);
            System.out.println("point joueur"+j.getPoints()+", points tirage "+game.getPointTour());

        ArrayList<Carte> tirage2 = p.tirage2Cartes();
            game.calculPoint(tirage2,game);
        System.out.println (tirage2);
            System.out.println("point joueur"+j.getPoints()+", points tirage "+game.getPointTour());

        ArrayList<Carte> tirage3 = p.tirage2Cartes();
            game.calculPoint(tirage3,game);
        System.out.println (tirage3);
            System.out.println("point joueur"+j.getPoints()+", points tirage "+game.getPointTour());


    }

}
