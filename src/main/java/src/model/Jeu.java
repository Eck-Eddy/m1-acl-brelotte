package src.model;

import java.util.ArrayList;

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

    public void calculPoint(ArrayList<Carte> cartetire)
    {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        int n = 0;
        setPointTour(0);
        if (c1.getValeur() != c2.getValeur() && c1.getColor() != c2.getColor())
        {
            n = c1.getValeur().getValeur()+c2.getValeur().getValeur();
            setPointTour(0+n);
            this.joueur.setPoints(this.joueur.getPoints()+n);
        }
        else if (c1.getValeur() == c2.getValeur() && c1.getColor() != c2.getColor())
        {
            n = c1.getValeur().getValeur()+c2.getValeur().getValeur();
            setPointTour(0-n);
            this.joueur.setPoints(this.joueur.getPoints()-n);
        }
        else if (c1.getValeur() == c2.getValeur() && c1.getColor() == c2.getColor())
        {
            n = c1.getValeur().getValeur()+c2.getValeur().getValeur();
            setPointTour(0-2*n);
            this.joueur.setPoints(this.joueur.getPoints()-(2*n));
        }

    }

    public Paquet getPaquetCarte() {
        return paquetCarte;
    }

    public void setPaquetCarte(Paquet paquetCarte) {
        this.paquetCarte = paquetCarte;
    }
}
