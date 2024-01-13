package CORRegles;

import src.model.Carte;
import src.model.Jeu;
import src.model.Joueur;

import java.util.ArrayList;

/**
 * Classe qui gère la règle des cartes de même valeur
 */
public class MemeValeurHandler extends ExpertCOR {
    private Joueur joueur;
    private Jeu jeu;

    /**
     * Constructeur de la classe
     * @param jeu
     */
    public MemeValeurHandler(Jeu jeu) {
        this.joueur = jeu.getJoueur();
        this.jeu = jeu;

    }


    /**
     * fonction peut gérer le cas
     * @param cartetire
     * @return
     */
    @Override
    protected boolean canHandle(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        return c1.getValeur() == c2.getValeur() && c1.getColor() != c2.getColor();
    }


    /**
     * procédure qui gère le calcul des points pour cette règle
     * @param cartetire
     */
    @Override
    public void calculPoint(ArrayList<Carte> cartetire) {
        Carte c1 = cartetire.get(0);
        Carte c2 = cartetire.get(1);
        int n = c1.getNbPoint()+c2.getNbPoint();
        jeu.setPointTour(-n);
        joueur.setPoints(joueur.getPoints()-n);
    }
}
