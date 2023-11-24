package CORRegles;

import src.model.Carte;
import java.util.ArrayList;

import src.model.Jeu;
import src.model.Joueur;

public class CouleurEtValeurDiffHandler extends ExpertCOR {
    Joueur joueur;
    Jeu jeu;
    public CouleurEtValeurDiffHandler(Jeu jeu) {
        this.joueur = jeu.getJoueur();
        this.jeu = jeu;

    }

    @Override
    protected boolean canHandle(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        return c1.getValeur() != c2.getValeur() && c1.getColor() != c2.getColor();
    }


    @Override
    public void calculPoint(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        int n = c1.getValeur().getValeur()+c2.getValeur().getValeur();
        jeu.setPointTour(n);
        joueur.setPoints(joueur.getPoints()+n);
    }
}
