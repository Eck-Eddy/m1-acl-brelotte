package src.model;

import java.util.ArrayList;
import CORRegles.*;

/**
 * Classe Jeu qui représente le jeu et permet les manipulations
 */
public class Jeu {

    /**
     * entier qui contient le nombre de tour
     */
    private int nbTour;

    /**
     * entier qui contient le nombre de point que le joueur a reçu durant le tour
     */
    private int pointTour;

    /**
     * Représente le Joueur de la partie
     */
    private Joueur joueur;

    /**
     * Représente le Paquet que le Jeu a
     */
    private Paquet paquetCarte;

    /**
     * Constructeur d'un Jeu
     * @param j Représente le Joueur qui joue la partie
     */
    public Jeu(Joueur j)
    {
        joueur = j;
        nbTour = 5;
        pointTour = 0;
        paquetCarte = new Paquet();
    }

    /**
     * Donne le Joueur est affecté à la partie
     * @return
     */
    public Joueur getJoueur()
    {
        return this.joueur;
    }

    /**
     * Donne le nombre de tour de la partie
     * @return
     */
    public int getNbTour()
    {
        return this.nbTour;
    }

    /**
     * Donne le nombre de point que le joueur à reçu dans ce tour
     * @return
     */
    public int getPointTour()
    {
        return this.pointTour;
    }

    /**
     * Permet de modifier le nombre de tour de la partie
     * @param nb
     * @throws IllegalArgumentException si le nombre de tour est négatif
     */
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

    /**
     * Permet de modifier le nombre de points du tour
     * @param point nombre de point que l'on souhaite attribué
     */
    public void setPointTour(int point)
    {
        this.pointTour = point;
    }

    /**
     * Calcul le nombre de point en fonction du tirage
     * @param cartetire Liste des cartes qui ont été tiré
     * @param jeu
     */
    public void calculPoint(ArrayList<Carte> cartetire, Jeu jeu)
    {
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

    /**
     * Permet de retourner le Paquet de carte qui est utilisé par le jeu
     * @return
     */
    public Paquet getPaquetCarte() {
        return paquetCarte;
    }

    /**
     * Permet de modifier le paquet que le jeu va utilisé
     * @param paquetCarte paquet de carte que l'on veut affecté au jeu
     */
    public void setPaquetCarte(Paquet paquetCarte) {
        this.paquetCarte = paquetCarte;
    }
}
