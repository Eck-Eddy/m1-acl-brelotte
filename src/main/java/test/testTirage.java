package test;

import src.model.Carte;
import src.model.Paquet;

import java.util.ArrayList;

public class testTirage {

    public static void main(String[] args)
    {
        int i;
        for ( i=0; i<100000;i++)
        {
            Paquet p = new Paquet();
            ArrayList<Carte> tirage = p.tirage2Cartes();
            System.out.println (tirage);

            if (tirage.get(0).getNom() == tirage.get(1).getNom())
            {
                throw new IllegalArgumentException("carte identique");
            }
        }

    }

}
