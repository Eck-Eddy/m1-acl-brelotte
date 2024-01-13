package CORRegles;

import src.model.Carte;
import java.util.ArrayList;

import src.model.Jeu;
import src.model.Joueur;

/**
 *
 * Classe qui gère la règle de si les cartes sont de valeur et de couleur différentes
 */
public class CouleurEtValeurDiffHandler extends ExpertCOR {

    private Joueur joueur;
    private Jeu jeu;

    /**
     * Constructeur de la classe
     * @param jeu
     */
    public CouleurEtValeurDiffHandler(Jeu jeu) {
        this.joueur = jeu.getJoueur();
        this.jeu = jeu;

    }

    /**
     * fonction qui voit si la règle peut gérer le cas
     * @param cartetire
     * @return
     */
    @Override
    protected boolean canHandle(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        return c1.getValeur() != c2.getValeur() && c1.getColor() != c2.getColor();
    }


    /**
     * procédure qui gère le calcul des points
     * @param cartetire
     */
    @Override
    public void calculPoint(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        int n = c1.getNbPoint()+c2.getNbPoint();
        jeu.setPointTour(n);
        joueur.setPoints(joueur.getPoints()+n);
    }
}
