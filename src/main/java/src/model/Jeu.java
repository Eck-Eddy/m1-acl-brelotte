package src.model;

import java.util.ArrayList;
import CORRegles.*;

public class Jeu {
    private int nbTour;
    private int pointTour;
    private Joueur joueur;
    private Paquet paquetCarte;

    public Jeu(Joueur j)
    {
        joueur = j;
        nbTour = 5;
        pointTour = 0;
        paquetCarte = new Paquet();
    }

    public Joueur getJoueur()
    {
        return this.joueur;
    }

    public int getNbTour()
    {
        return this.nbTour;
    }

    public int getPointTour()
    {
        return this.pointTour;
    }

    public void setNbTour(int nb)
    {
        if (nb<0)
        {
            System.err.println("nbTour inferieur à 0");
            throw new IllegalArgumentException("nbTour inferieur à 0");
        }
        else
        {
            this.nbTour = nb;
        }
    }

    public void setPointTour(int point)
    {
        this.pointTour = point;
    }

    public void calculPoint(ArrayList<Carte> cartetire, Jeu jeu)
    {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        int n = 0;
        setPointTour(0);
        // Créez une chaîne de gestionnaires
        Expert CouleurEtValeurDiffHandler = new CouleurEtValeurDiffHandler(jeu);
        Expert MemeValeurDiffHandler = new MemeValeurHandler(jeu);
        Expert MemeValeurEtMemeCouleurHandler = new MemeValeurEtMemeCouleurHandler(jeu);

        CouleurEtValeurDiffHandler.setNextHandler(MemeValeurDiffHandler);
        MemeValeurDiffHandler.setNextHandler(MemeValeurEtMemeCouleurHandler);

        // Commencer le traitement avec le premier gestionnaire de la chaîne
        CouleurEtValeurDiffHandler.handle(cartetire);

    }

    public Paquet getPaquetCarte() {
        return paquetCarte;
    }

    public void setPaquetCarte(Paquet paquetCarte) {
        this.paquetCarte = paquetCarte;
    }
}
